package app.wiper.coupons.rules;

import app.wiper.domain.core.Coupon;
import app.wiper.domain.core.Order;
import app.wiper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * An {@link EligibilityRule} which checks if the given order is the first order
 * for a customer.
 *
 * @author Shekhar
 */
@Component
public class FirstOrderRule extends EligibilityRule
{
    @Autowired
    private OrderService orderService;

    @Override
    public String getRuleCode()
    {
        return "first_order";
    }

    @Override
    protected boolean isValidOrder(Order order, Coupon coupon)
    {
        return orderService
                .getOrdersByCustomerId(
                        order.getCustomerId())
                .isEmpty();
    }
}
