package app.wiper.service;

import app.wiper.domain.core.Payment;
import app.wiper.domain.core.ServiceDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService
{
    Payment getPaymentById(Integer paymentId);
    List<ServiceDetails> getServiceDetailsForPaymentId(Integer paymentId);
}
