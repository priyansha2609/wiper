package app.wiper.domain.core;

import app.wiper.domain.type.Area;
import app.wiper.domain.type.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleAddress {
	Integer addressId;
	String parkingLotNo;
	String floor;
	String building;
	Area area;
	City city;
	Integer pin;

}
