package app.wiper.service.impl;

import app.wiper.domain.core.OrderCart;
import app.wiper.domain.core.Payment;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.service.OrderCartService;
import app.wiper.service.PaymentService;
import app.wiper.service.ServiceDetailsService;
import app.wiper.util.Constants.TRANSACTION_STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class OrderCartServiceImpl implements OrderCartService
{
    @Autowired
    private ServiceDetailsService serviceDetailsService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public Integer processOrderCart(OrderCart orderCart)
    {
        List<ServiceDetails> serviceDetails = orderCart.getServiceDetails();

        Payment payment = orderCart.getPayment();
        payment.setDateOfPayment(Date.from(Instant.now()));

        // We mark the status as pending as the transaction is yet to complete.
        // Once the transaction is completed the status in the payment object
        // must be updated to reflect the correct status.
        payment.setTransactionStatus(2);

        Integer paymentId = paymentService.insertPayment(payment);

        // Currently we mark all the subscriptions as inactive. They should be
        // marked active once the related transaction has been processed
        // successfully.
        serviceDetails.forEach(sd -> sd.setIsActive(false));
        serviceDetails.forEach(sd -> sd.setPayment(payment));
        serviceDetails.forEach(sd -> serviceDetailsService.insertServiceDetails(sd));

        return paymentId;
    }
}
