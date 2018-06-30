package app.wiper.service.impl;

import app.wiper.domain.core.Order;
import app.wiper.domain.core.OrderCart;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.service.OrderCartService;
import app.wiper.service.OrderService;
import app.wiper.service.ServiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderCartServiceImpl implements OrderCartService
{
    @Autowired
    private ServiceDetailsService serviceDetailsService;

    @Autowired
    private OrderService orderService;

    @Override
    public Integer processOrderCart(OrderCart orderCart)
    {
        List<ServiceDetails> serviceDetails = orderCart.getServiceDetails();

        Order order = orderCart.getOrder();
        order.setDateOfPayment(Date.from(Instant.now()));

        // We mark the status as pending as the transaction is yet to complete.
        // Once the transaction is completed the status in the order object
        // must be updated to reflect the correct status.
        order.setTransactionStatus(2);

        Integer orderId = orderService.insertOrder(order);

        order.setOrderId(orderId);

        // Currently we mark all the subscriptions as inactive. They should be
        // marked active once the related transaction has been processed
        // successfully.
        serviceDetails.forEach(sd -> sd.setIsActive(false));
        serviceDetails.forEach(sd -> sd.setOrder(order));
        serviceDetails.forEach(sd -> serviceDetailsService.insertServiceDetails(sd));

        return orderId;
    }

    private OrderCart createNewOrderCart(Order order)
    {
        return new OrderCart(
                order,
                serviceDetailsService.getServiceDetailsForOrderId(
                    order.getOrderId()));
    }

    @Override
    public List<OrderCart> getAllOrdersForCustomer(Integer customerId)
    {
        List<Order> customerOrders =
                orderService.getOrdersByCustomerId(customerId);

        return customerOrders.stream()
                .map(this::createNewOrderCart)
                .collect(Collectors.toList());
    }

    @Override
    public OrderCart getOrderByOrderId(Integer orderId)
    {
        Order order = orderService.getOrderById(orderId);
        return createNewOrderCart(order);
    }
}
