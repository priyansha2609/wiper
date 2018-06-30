package app.wiper.domain.core;

import java.util.Date;

import app.wiper.util.Constants.TRANSACTION_STATUS;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
	Integer orderId;
	Integer customerId;
	Date dateOfPayment;
	Double amountOfPayment;
	Double basicCharge;
	Double taxPercent;
	Integer modeOfPayment;
	String comment;
//    TRANSACTION_STATUS transactionStatus;
	Integer transactionStatus;
}
