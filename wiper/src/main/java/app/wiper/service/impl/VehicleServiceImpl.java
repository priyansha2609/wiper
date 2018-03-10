package app.wiper.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.wiper.domain.core.CorrespondenceAddress;
import app.wiper.domain.core.Employee;
import app.wiper.domain.core.EmployeeLocation;
import app.wiper.domain.core.Vehicle;
import app.wiper.domain.core.VehicleAddress;
import app.wiper.mapper.interfaces.AddressMapper;
import app.wiper.mapper.interfaces.VehicleMapper;
import app.wiper.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleMapper vehicleMapper;
	
	@Autowired
	AddressMapper addressMapper;

	@Override
	public Vehicle getVehicleById(Integer vehicleId) {
		return vehicleMapper.getVehicleById(vehicleId);
	}
	
	@Override
	public void insertVehicle(Integer customerId,Vehicle vehicle) {
		Integer vehicleId = insertBasicDataForVehicle(customerId,vehicle);
		vehicle.setVehicleId(vehicleId);
		insertAddressForVehicle(vehicleId, vehicle.getVehicleAddress());
	}
	
	public void insertAddressForVehicle(Integer vehicleId, VehicleAddress address) {
		Map<String, Object> params = new HashMap<>();
        params.put("vehicleId", vehicleId);
        params.put("address", address);
        addressMapper.insertAddressForVehicle(params);
	}
	
	
	public Integer insertBasicDataForVehicle(Integer customerId,Vehicle vehicle) {
		Map<String, Object> params = new HashMap<>();
		params.put("customerId", customerId);
        params.put("vehicle", vehicle);
        vehicleMapper.insertBasicDataForVehicle(params);
        Integer vehicleId = (Integer) params.get("vehicleId");
        return vehicleId;       
	}

}
