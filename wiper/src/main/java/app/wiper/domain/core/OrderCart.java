package app.wiper.domain.core;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCart
{
    List<ServiceDetails> serviceDetails;
    Order order;
    Coupon coupon;

    public OrderCart()
    {}

    public OrderCart(Order order,
                     List<ServiceDetails> serviceDetails,
                     Coupon coupon)
    {
        this.order = order;
        this.serviceDetails = serviceDetails;
        this.coupon = coupon;
    }
}