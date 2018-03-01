package app.wiper.mapper.interfaces;

import java.util.List;

import app.wiper.domain.type.VehicleType;

public interface VehicleTypeMapper {
	
	    List<VehicleType> getAllVehicleTypes();
	    
	    VehicleType getVehicleTypeById(Integer id);
	}


