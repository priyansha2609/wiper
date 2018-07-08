package app.wiper.service;

import app.wiper.domain.core.Order;
import app.wiper.domain.core.ServiceDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService
{
    Order getOrderById(Integer orderId);
    List<ServiceDetails> getServiceDetailsForOrderId(Integer orderId);
    Integer insertOrder(Order order);
    Integer updateOrder(Order order);
    void processPaymentResponse(String paymentMode,
                                Integer orderId,
                                boolean isValidResponse);
    List<Order> getOrdersByCustomerId(Integer customerId);
}
