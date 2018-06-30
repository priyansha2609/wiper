package app.wiper.service;

import app.wiper.domain.core.OrderCart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderCartService
{
    public Integer processOrderCart(OrderCart orderCart);
    public List<OrderCart> getAllOrdersForCustomer(Integer customerId);
}
