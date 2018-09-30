package app.wiper.controller;

import app.wiper.domain.core.Coupon;
import app.wiper.domain.core.Order;
import app.wiper.domain.core.OrderCart;
import app.wiper.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController
{
    @Autowired
    private CouponService couponService;


    @RequestMapping("/getCouponByCouponCode")
    public Coupon getCouponByCouponCode(@RequestParam String couponCode)
    {
        return couponService.getCouponByCouponCode(couponCode);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/isCouponApplicable")
    public Boolean isValidCoupon(@RequestBody OrderCart orderCart)
    {
        return couponService.isOrderEligibleForCoupon(orderCart.getOrder(),
                                                      orderCart.getCoupon());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/applyCoupon")
    public Order applyCoupon(@RequestBody OrderCart orderCart)
    {
        return couponService.applyCoupon(
                orderCart.getOrder(),
                orderCart.getCoupon());
    }
}