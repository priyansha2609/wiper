package app.wiper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.wiper.domain.core.Vehicle;
import app.wiper.mapper.interfaces.VehicleMapper;
import app.wiper.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleMapper vehicleMapper;

	@Override
	public Vehicle getVehicleById(Integer vehicleId) {
		return vehicleMapper.getVehicleById(vehicleId);
	}

}
