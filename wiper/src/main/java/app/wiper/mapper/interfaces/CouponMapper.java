package app.wiper.mapper.interfaces;

import app.wiper.domain.core.Coupon;

public interface CouponMapper
{
    Coupon getCouponById(Integer couponId);
    Coupon getCouponByCouponCode(String couponCode);
}
