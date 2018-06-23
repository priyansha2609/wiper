package app.wiper.service.impl;

import app.wiper.domain.core.Customer;
import app.wiper.domain.core.Payment;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.mapper.interfaces.PaymentMapper;
import app.wiper.service.CustomerService;
import app.wiper.service.PaymentService;
import app.wiper.service.ServiceDetailsService;
import app.wiper.service.mail.MailClient;
import app.wiper.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    PaymentMapper paymentMapper;

    @Autowired
    ServiceDetailsService serviceDetailsService;

    @Autowired
    MailClient mailClient;

    @Autowired
    CustomerService customerService;

    private Integer upsertPayment(Payment payment)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("payment", payment);
        paymentMapper.upsertPayment(params);

        return (Integer) params.get("paymentId");
    }

    @Override
    public Payment getPaymentById(Integer paymentId)
    {
        return paymentMapper.getPaymentById(paymentId);
    }

    @Override
    public List<ServiceDetails> getServiceDetailsForPaymentId(Integer paymentId)
    {
        return serviceDetailsService.getServiceDetailsForPaymentId(paymentId);
    }

    @Override
    public Integer insertPayment(Payment payment)
    {
        return upsertPayment(payment);
    }

    @Override
    public Integer updatePayment(Payment payment)
    {
        return upsertPayment(payment);
    }

    private void processSucessfulPayment(Payment payment)
    {
        payment.setTransactionStatus(Integer.valueOf(1));
        List<ServiceDetails> serviceDetailsList =
                serviceDetailsService.getServiceDetailsForPaymentId(payment.getPaymentId());

        serviceDetailsList.forEach(sd -> sd.setIsActive(true));
        serviceDetailsList.forEach(sd -> serviceDetailsService.updateServiceDetails(sd));

        updatePayment(payment);


    }

    private void processFailedPayment(Payment payment)
    {
        payment.setTransactionStatus(Integer.valueOf(0));
        updatePayment(payment);
    }

    @Override
    public void processPaymentResponse(Integer paymentMode,
                                       Integer paymentId,
                                       boolean isValidResponse)
    {
        Payment payment = getPaymentById(paymentId);
        payment.setModeOfPayment(paymentMode);

        if (isValidResponse) {
            processSucessfulPayment(payment);
        }
        else{
            processFailedPayment(payment);
        }

        notifyCustomer(payment, isValidResponse);
    }

    private void notifyCustomer(Payment payment, boolean isValidTransaction)
    {
        Customer customer = customerService.getCustomerById(payment.getCustomerId());
        String subject = "Transaction successful";
        String message = "Hello " + customer.getName() + ",\n\nYour transaction" +
                " for Order#" + payment.getPaymentId() +
                (isValidTransaction ? " was successful!": " failed! Please retry.");

        mailClient.prepareAndSend(customer.getCredentials().getEmailId(),
                subject, message);
    }
}
