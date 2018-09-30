package app.wiper.coupons.rules;

import app.wiper.domain.core.Coupon;
import app.wiper.domain.core.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * A rule to define the conditions which needs to be checked on the order and
 * the coupon before applying the discount.
 *
 * @author Shekhar
 */
@Component
public abstract class EligibilityRule
{
    public abstract String getRuleCode();

    /**
     * The method needs to be called before applying coupon on an order.
     *
     * This methods checks whether the specified coupon is a valid and in active
     * state and then verifies if it is applicable on the order or not.
     */
    public final boolean isCouponApplicable(Order order, Coupon coupon)
    {
        Date orderDate = order.getDateOfPayment();
        if (!coupon.getIsActive() ||
            orderDate.before(coupon.getStartDate()) ||
            orderDate.after(coupon.getEndDate()))
        {
            return false;
        }

        return isValidOrder(order, coupon);
    }

    /**
     * Checks whether the order statisfies the criteria specified by the rule.
     */
    protected abstract boolean isValidOrder(Order order, Coupon coupon);
}
