package app.wiper.service.impl;

import app.wiper.domain.core.Customer;
import app.wiper.domain.core.Order;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.mapper.interfaces.OrderMapper;
import app.wiper.service.CustomerService;
import app.wiper.service.OrderService;
import app.wiper.service.ServiceDetailsService;
import app.wiper.service.mail.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ServiceDetailsService serviceDetailsService;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private CustomerService customerService;

    private Integer upsertOrder(Order order)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("order", order);
        orderMapper.upsertOrder(params);

        return (Integer) params.get("orderId");
    }

    @Override
    public Order getOrderById(Integer orderId)
    {
        return orderMapper.getOrderById(orderId);
    }

    @Override
    public List<ServiceDetails> getServiceDetailsForOrderId(Integer orderId)
    {
        return serviceDetailsService.getServiceDetailsForOrderId(orderId);
    }

    @Override
    public Integer insertOrder(Order order)
    {
        return upsertOrder(order);
    }

    @Override
    public Integer updateOrder(Order order)
    {
        return upsertOrder(order);
    }

    private void processSucessfulPayment(Order order)
    {
        order.setTransactionStatus(Integer.valueOf(1));
        List<ServiceDetails> serviceDetailsList =
                serviceDetailsService.getServiceDetailsForOrderId(order.getOrderId());

        serviceDetailsList.forEach(sd -> sd.setIsActive(true));
        serviceDetailsList.forEach(sd -> serviceDetailsService.updateServiceDetails(sd));

        updateOrder(order);


    }

    private void processFailedPayment(Order order)
    {
        order.setTransactionStatus(Integer.valueOf(0));
        updateOrder(order);
    }

    @Override
    public void processPaymentResponse(Integer paymentMode,
                                       Integer orderId,
                                       boolean isValidResponse)
    {
        Order order = getOrderById(orderId);
        order.setModeOfPayment(paymentMode);

        if (isValidResponse) {
            processSucessfulPayment(order);
        }
        else{
            processFailedPayment(order);
        }

        notifyCustomer(order, isValidResponse);
    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer customerId)
    {
        return orderMapper.getOrdersByCustomerId(customerId);
    }

    private void notifyCustomer(Order order, boolean isValidTransaction)
    {
        Customer customer = customerService.getCustomerById(order.getCustomerId());
        String subject = "Transaction successful";
        String message = "Hello " + customer.getName() + ",\n\nYour transaction" +
                " for Order#" + order.getOrderId() +
                (isValidTransaction ? " was successful!": " failed! Please retry.");

        mailClient.prepareAndSend(customer.getCredentials().getEmailId(),
                subject, message);
    }
}
