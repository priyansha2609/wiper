package app.wiper.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.wiper.domain.type.EntityType;
import app.wiper.domain.type.VehicleType;
import app.wiper.mapper.interfaces.EntityTypeMapper;
import app.wiper.mapper.interfaces.VehicleTypeMapper;
import app.wiper.service.MetaDataService;

@Service
public class MetaDataServiceImpl implements MetaDataService{
	
	@Autowired
	VehicleTypeMapper vehicleTypeMapper;
	
	@Autowired
	EntityTypeMapper entityTypeMapper;

	@Override
	public List<VehicleType> getAllVehicleTypes() {
		List<VehicleType> vehicleTypes = new ArrayList<>();
		vehicleTypes = vehicleTypeMapper.getAllVehicleTypes();
		return vehicleTypes;
	}

	@Override
	public List<EntityType> getAllEntityTypes() {
		List<EntityType> entityTypes = new ArrayList<>();
		entityTypes = entityTypeMapper.getAllEntityTypes();
		return entityTypes;
	}
 
    @Override
   	public VehicleType getVehicleTypeById(Integer id) {
    		return vehicleTypeMapper.getVehicleTypeById(id);
	}
	
	@Override
	public EntityType getEntityTypeById(Integer id) {
		return entityTypeMapper.getEntityTypeById(id);
		
	}
	

}
