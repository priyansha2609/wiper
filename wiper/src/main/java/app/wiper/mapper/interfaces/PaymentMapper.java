package app.wiper.mapper.interfaces;

import app.wiper.domain.core.Payment;

import java.util.List;

public interface PaymentMapper
{
    Payment getPaymentById(Integer paymentId);
    List<Payment> getPaymentFromServiceDetailId(Integer serviceDetailId);
}
