package app.wiper.coupons.rules;

import app.wiper.domain.core.Coupon;
import app.wiper.domain.core.Order;
import org.springframework.stereotype.Component;

/**
 * This {@link EligibilityRule} defines a minimum order amount criteria for
 * a coupon i.e. the coupon associated with this rule is only applicable on
 * the order if the order amount is greater than the threshold.
 *
 * @author Shekhar
 */
@Component
public class OrderAmountThresholdRule extends EligibilityRule
{
    /**
     * The minimum order amount above which the coupon is applicable.
     */
    private final Double myAmountThreshold;

    public OrderAmountThresholdRule()
    {
        myAmountThreshold = 100.0;
    }

    public OrderAmountThresholdRule(Double amountThreshold)
    {
        myAmountThreshold = amountThreshold;
    }

    /**
     * This rule expects the rule code in form of 'amount_threshold_500',
     * where 500 would be the threshold will be Rs. 500.
     */
    public OrderAmountThresholdRule(String ruleCode)
    {
        if (!ruleCode.contains("amount_threshold_")) {
            throw new IllegalArgumentException("Invalid coupon code " +
                    ruleCode + " specified!");
        }
        String tokens[] = ruleCode.split("_");

        myAmountThreshold = Double.valueOf(tokens[tokens.length - 1]);
    }

    @Override
    public String getRuleCode()
    {
        return "amount_threshold_" + myAmountThreshold;
    }

    @Override
    protected boolean isValidOrder(Order order, Coupon coupon)
    {
        return order.getBasicCharge() >= myAmountThreshold;
    }
}
