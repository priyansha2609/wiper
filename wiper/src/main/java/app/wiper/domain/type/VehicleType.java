package app.wiper.domain.type;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleType implements Serializable{

	Integer vehicleTypeId;
	
	String name;
	
	String description;
	
	Boolean isActive;
	
	Integer orderId;

}
