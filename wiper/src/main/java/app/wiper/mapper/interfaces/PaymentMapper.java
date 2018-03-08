package app.wiper.mapper.interfaces;

import app.wiper.domain.core.Payment;

public interface PaymentMapper {
	
	Payment getPaymentById(Integer paymentId);
}
