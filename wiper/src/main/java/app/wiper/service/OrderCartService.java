package app.wiper.service;

import app.wiper.domain.core.OrderCart;
import org.springframework.stereotype.Service;

@Service
public interface OrderCartService
{
    public Integer processOrderCart(OrderCart orderCart);
}
