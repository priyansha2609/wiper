package app.wiper.domain.type;

import java.util.Date;

public interface Service {
	
	Integer getRateForVehicleType(VehicleType vehicleType);
	Integer getRateForVehicleTypeAndDate(VehicleType vehicleType, Date date);
	
}
