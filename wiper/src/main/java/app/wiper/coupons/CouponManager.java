package app.wiper.coupons;

import app.wiper.coupons.rules.EligibilityManager;
import app.wiper.domain.core.Coupon;
import app.wiper.domain.core.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class applies a coupon on the specified order
 */
@Component
public class CouponManager
{
    @Autowired
    private EligibilityManager eligibilityManager;

    /**
     * Verifies that the order is eligible for the coupon and then applies it.
     */
    public Order applyCoupon(Order order, Coupon coupon)
    {
        // Apply the discount if eligible and not applied already.
        if ((order.getDiscount() == null   ||
             order.getDiscount() == 0.0) &&
            eligibilityManager.isCouponApplicableOnOrder(order, coupon))
        {
            Double discount = 0.0;

            // Apply discount on basic charges if any.
            if (coupon.getBasicDiscountPercent() != null) {
                discount +=
                    coupon.getBasicDiscountPercent() * order.getBasicCharge() / 100;
            }

            // Apply discount on taxes if any.
            if (coupon.getTaxDiscountPercent() != null) {
                discount +=
                    coupon.getTaxDiscountPercent() * order.getTaxes() / 100;
            }

            // Apply discount on total charges, if any. Note that the discount
            // is either applied on the basic and taxes or on the total charges
            // but not both.
            if (discount == 0.0 && coupon.getTotalDiscountPercent() != null) {
                discount =
                    coupon.getTotalDiscountPercent() *
                    (order.getBasicCharge() + order.getTaxes()) / 100;
            }

            // Apply the discount.
            discount = Math.min(discount, coupon.getDiscountLimitAmount());
            order.setAmountOfPayment(
                order.getBasicCharge() + order.getTaxes() - discount);
            order.setDiscount(discount);
            order.setCoupon(coupon);
        }

        return order;
    }
}
