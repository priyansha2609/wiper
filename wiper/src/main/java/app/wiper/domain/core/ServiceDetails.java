package app.wiper.domain.core;

import java.util.Date;

import app.wiper.domain.type.Service;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDetails {
	Integer serviceDetailId;
	Service service;
	Date subscriptionStartDate;
	Date subscriptionEndDate;
	Float amountPaid;
	Integer bufferDaysAvailable;
	Payment payment;
	Boolean isActive;
}
