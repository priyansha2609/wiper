package app.wiper.service;

import app.wiper.domain.core.Coupon;
import app.wiper.domain.core.Order;
import org.springframework.stereotype.Service;

@Service
public interface CouponService
{
    Coupon getCouponById(Integer couponId);
    Coupon getCouponByCouponCode(String couponCode);
    Order applyCoupon(Order order, Coupon coupon);
    Boolean isOrderEligibleForCoupon(Order order, Coupon coupon);
}
