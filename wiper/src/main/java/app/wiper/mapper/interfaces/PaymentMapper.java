package app.wiper.mapper.interfaces;

import app.wiper.domain.core.Payment;

import java.util.List;
import java.util.Map;

public interface PaymentMapper
{
    Payment getPaymentById(Integer paymentId);
    Integer upsertPayment(Map<String, Object> params);
}
