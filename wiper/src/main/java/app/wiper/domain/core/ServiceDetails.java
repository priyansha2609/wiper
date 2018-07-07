package app.wiper.domain.core;

import java.util.Date;

import app.wiper.domain.type.ServiceSlot;
import app.wiper.domain.type.ServiceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDetails {
	Integer serviceDetailId;
    Integer vehicleId;
	ServiceType service;
	Date subscriptionStartDate;
	Date subscriptionEndDate;
	Float amountPaid;
	Integer bufferDaysAvailed;
	Boolean isActive;
	Order order;
	ServiceSlot serviceSlot;
}
