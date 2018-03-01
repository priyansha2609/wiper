package app.wiper.domain.core;

import app.wiper.domain.type.Service;
import app.wiper.domain.type.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rate {
	
	Service service;
	VehicleType vehicleType;
	Float price;
	//have effective start date and end date for price

}
