package app.wiper.domain.core;

import java.util.List;

import app.wiper.domain.type.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
	
	Integer vehicleId;
	String vehicleNumber;
	VehicleType vehicleType;
	VehicleAddress vehicleAddress;
	String comments;
	List<ServiceDetails> servicesDetails;
	Boolean isActive;
}
