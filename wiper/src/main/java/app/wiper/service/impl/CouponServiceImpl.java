package app.wiper.service.impl;

import app.wiper.coupons.CouponManager;
import app.wiper.coupons.rules.EligibilityManager;
import app.wiper.domain.core.Coupon;
import app.wiper.domain.core.Order;
import app.wiper.mapper.interfaces.CouponMapper;
import app.wiper.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService
{
    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private CouponManager couponManager;

    @Autowired
    private EligibilityManager eligibilityManager;

    @Override
    public Coupon getCouponById(Integer couponId)
    {
        return couponMapper.getCouponById(couponId);
    }

    @Override
    public Coupon getCouponByCouponCode(String couponCode)
    {
        return couponMapper.getCouponByCouponCode(couponCode);
    }

    @Override
    public Order applyCoupon(Order order, Coupon coupon)
    {
        return couponManager.applyCoupon(order, coupon);
    }

    @Override
    public Boolean isOrderEligibleForCoupon(Order order, Coupon coupon)
    {
        return eligibilityManager.isCouponApplicableOnOrder(order, coupon);
    }
}
