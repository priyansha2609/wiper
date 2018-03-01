package app.wiper.domain.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleAddress {
	String parkingLotNo;
	String floor;
	String building;
	String city;
	String state;
	Integer pin;

}
