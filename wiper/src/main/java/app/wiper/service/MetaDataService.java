package app.wiper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.wiper.domain.type.EntityType;
import app.wiper.domain.type.VehicleType;

@Service
public interface MetaDataService {

	List<VehicleType> getAllVehicleTypes();
	
	List<EntityType> getAllEntityTypes();

	VehicleType getVehicleTypeById(Integer id);
	
	EntityType getEntityTypeById(Integer id);
}
