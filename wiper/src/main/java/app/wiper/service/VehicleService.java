package app.wiper.service;


import org.springframework.stereotype.Service;

import app.wiper.domain.core.Vehicle;
import app.wiper.domain.core.VehicleAddress;

@Service
public interface VehicleService {
	Vehicle getVehicleById(Integer vehicleId);
	
	void insertVehicle(Integer customerId, Vehicle vehicle);
	

}
