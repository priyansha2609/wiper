package app.wiper.domain.core;

import java.util.Date;

import app.wiper.domain.type.TransactionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
	Integer paymentId;
	Integer customerId;
	Date dateOfPayment;
	Integer amountOfPayment;
	Integer basicCharge;
	Float taxPercent;
	Integer modeOfPayment;
	String comment;
    TransactionStatus transactionStatus;
}
