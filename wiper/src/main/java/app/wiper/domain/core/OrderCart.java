package app.wiper.domain.core;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCart
{
    List<ServiceDetails> serviceDetails;
    Payment payment;

    public OrderCart(Payment payment, List<ServiceDetails> serviceDetails)
    {
        this.payment = payment;
        this.serviceDetails = serviceDetails;
    }
}