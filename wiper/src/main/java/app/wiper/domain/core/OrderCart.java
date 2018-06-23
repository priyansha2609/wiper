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
}
