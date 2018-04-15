package app.wiper.mapper.interfaces;

import java.util.List;
import java.util.Map;

import app.wiper.domain.type.VehicleType;

public interface VehicleTypeMapper {
	
	    List<VehicleType> getAllVehicleTypes();
	    
	    VehicleType getVehicleTypeById(Integer vehicleTypeId);
	    Integer upsertVehicleType(Map<String, Object> params);
	}


