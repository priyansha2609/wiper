package app.wiper.coupons.rules;

import app.wiper.domain.core.Coupon;
import app.wiper.domain.core.Order;
import org.springframework.stereotype.Component;

/**
 * An {@link EligibilityRule} which should be associated with a coupon for which
 * all orders are eligible.
 */
@Component
public class AllOrderRule extends EligibilityRule
{
    @Override
    public String getRuleCode()
    {
        return "all_orders";
    }

    @Override
    protected boolean isValidOrder(Order order, Coupon coupon)
    {
        return true;
    }
}
