package app.wiper.coupons.rules;

import app.wiper.domain.core.Coupon;
import app.wiper.domain.core.Order;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class to manage all {@link EligibilityRule}'s. This class also provides
 * utility methods associated with getting applicable rules for a given coupon
 * code etc.
 */
@Component
@Log4j2
public class EligibilityManager
{
    @Autowired
    private FirstOrderRule firstOrderRule;

    @Autowired
    private AllOrderRule allOrderRule;

    @Autowired
    private OrderAmountThresholdRule orderAmountThresholdRule;

    /**
     * A list of all rules.
     */
    private static List<EligibilityRule> ourRules;

    /**
     * Returns a set of rules applicable for the specified eligibility code.
     */
    private Set<EligibilityRule> getEligibilityRules(String eligibilityCode)
    {
        String ruleCodes[] = eligibilityCode.split("\\+");
        Map<String, EligibilityRule> codeToRuleMap = getAllEligibilityRules();

        return Stream.of(ruleCodes)
                     .filter(r -> r != null && !r.isEmpty())
                     .map(codeToRuleMap::get)
                     .collect(Collectors.toSet());
    }

    /**
     * Returns a map from rule eligibility code to the rule.
     */
    private Map<String, EligibilityRule> getAllEligibilityRules()
    {
        if (ourRules == null) {
            ourRules = Arrays.asList(
                    allOrderRule,
                    firstOrderRule,
                    orderAmountThresholdRule);
        }

        return ourRules.stream().collect(
                Collectors.toMap(EligibilityRule::getRuleCode,
                                 er -> er)
        );
    }

    /**
     * Returns true if the order satisfies all criteria required for the
     * coupon.
     */
    public boolean isCouponApplicableOnOrder(Order order, Coupon coupon)
    {
        Set<EligibilityRule> rules =
                getEligibilityRules(coupon.getEligibilityCode());

        log.info("eligible rule " + rules );
        return rules.stream().allMatch(r -> r.isCouponApplicable(order, coupon));
    }
}
