package app.wiper.domain.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleType {

	Integer vehicleTypeId;
	
	String name;
	
	String description;
	
	Boolean isActive;
	
	Integer orderId;

}
