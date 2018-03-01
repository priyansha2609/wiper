package app.wiper.service;


import org.springframework.stereotype.Service;

import app.wiper.domain.core.Vehicle;

@Service
public interface VehicleService {
	Vehicle getVehicleById(Integer vehicleId);

}
