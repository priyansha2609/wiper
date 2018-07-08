package app.wiper.service.impl;

import app.wiper.domain.core.Customer;
import app.wiper.domain.core.Order;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.mapper.interfaces.OrderMapper;
import app.wiper.mapper.interfaces.TransactionStatusMapper;
import app.wiper.service.CustomerService;
import app.wiper.service.OrderService;
import app.wiper.service.ServiceDetailsService;
import app.wiper.service.VehicleService;
import app.wiper.service.mail.MailClient;
import app.wiper.util.Constants.TRANSACTION_STATUS;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private TransactionStatusMapper transactionStatusMapper;

    @Autowired
    private ServiceDetailsService serviceDetailsService;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private VehicleService vehicleService;

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
        order.setTransactionStatus(
                transactionStatusMapper.getTransactionStatus(
                        TRANSACTION_STATUS.SUCCESS));
        List<ServiceDetails> serviceDetailsList =
                serviceDetailsService.getServiceDetailsForOrderId(order.getOrderId());

        serviceDetailsList.forEach(sd -> sd.setIsActive(true));
        serviceDetailsList.forEach(sd -> serviceDetailsService.updateServiceDetails(sd));

        updateOrder(order);

        notifyCustomer(order, serviceDetailsList, true);
    }

    private void processFailedPayment(Order order)
    {
        order.setTransactionStatus(
                transactionStatusMapper.getTransactionStatus(
                        TRANSACTION_STATUS.FAILURE));
        updateOrder(order);
    }

    @Override
    public void processPaymentResponse(String paymentMode,
                                       Integer orderId,
                                       boolean isValidResponse)
    {
        Order order = getOrderById(orderId);
        order.setModeOfPayment(paymentMode);

        if (isValidResponse) {
            processSucessfulPayment(order);
        }
        else{
            log.warn("Transaction failed: " + order);
            processFailedPayment(order);
        }
    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer customerId)
    {
        return orderMapper.getOrdersByCustomerId(customerId);
    }

    private void notifyCustomer(Order order,
                                List<ServiceDetails> serviceDetailsList,
                                boolean isValidTransaction)
    {
        Customer customer = customerService.getCustomerById(order.getCustomerId());
        String subject = "Transaction successful";
        String message = "Hello " + customer.getName() + ",\n\nYour transaction" +
                " for Order#" + order.getOrderId() +
                (isValidTransaction ? " was successful!": " failed! Please retry.");

        log.info("Transaction status: " + message);
        Map<String, Object> params = new HashMap<>();
        params.put("customerName", customer.getName());
        params.put("order", order);
        Map<Integer, String> vehicleNameMap = serviceDetailsList.stream()
                .collect(Collectors.toMap(
                        ServiceDetails::getVehicleId,
                        sd -> vehicleService.getVehicleById(sd.getVehicleId())
                                            .getVehicleNumber(),
                        (a, b) -> b));

        params.put("serviceDetails", serviceDetailsList);
        params.put("vehicleMap", vehicleNameMap);
        mailClient.prepareAndSend(customer.getCredentials().getEmailId(),
                subject, "PaymentSuccessMail", params);
    }
}
