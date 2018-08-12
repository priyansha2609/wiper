package app.wiper.domain.core;

import app.wiper.domain.type.Area;
import app.wiper.domain.type.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleAddress {
	Integer vehicleId;
	String parkingLot;
	String flatNumber;
	String building;
	Area area;
	City city;
	Integer pin;
    String subArea1;
    String subArea2;
}
