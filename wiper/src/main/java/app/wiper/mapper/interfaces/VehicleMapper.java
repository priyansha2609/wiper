package app.wiper.mapper.interfaces;

import java.util.List;

import app.wiper.domain.core.Vehicle;

public interface VehicleMapper {
	
	void upsertVehicleForCustomer();
	List<Vehicle> getAllVehiclesForCustomer(Integer customerId);
	Vehicle getVehicleById(Integer vehicleId);
	
}
