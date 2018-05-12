package app.wiper.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.wiper.domain.core.Rate;
import app.wiper.domain.type.ServiceType;
import app.wiper.mapper.interfaces.RateMapper;
import app.wiper.mapper.interfaces.ServiceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.wiper.domain.type.Area;
import app.wiper.domain.type.City;
import app.wiper.domain.type.EntityType;
import app.wiper.domain.type.VehicleType;
import app.wiper.mapper.interfaces.AddressMapper;
import app.wiper.mapper.interfaces.EntityTypeMapper;
import app.wiper.mapper.interfaces.VehicleTypeMapper;
import app.wiper.service.MetaDataService;

@Service
public class MetaDataServiceImpl implements MetaDataService{
	
	@Autowired
	VehicleTypeMapper vehicleTypeMapper;
	
	@Autowired
	EntityTypeMapper entityTypeMapper;
	

	@Autowired
	AddressMapper addressMapper;

    @Autowired
    ServiceTypeMapper serviceTypeMapper;

    @Autowired
    RateMapper rateMapper;

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
    public List<ServiceType> getAllServiceTypes()
    {
        return serviceTypeMapper.getAllServiceTypes();
    }

    @Override
    public List<Rate> getAllRates()
    {
        return rateMapper.getAllRates();
    }

    @Override
   	public VehicleType getVehicleTypeById(Integer id) {
    		return vehicleTypeMapper.getVehicleTypeById(id);
	}
	
	@Override
	public EntityType getEntityTypeById(Integer id) {
		return entityTypeMapper.getEntityTypeById(id);
		
	}

	@Override
	public List<City> getAllCities() {
		List<City> cities = new ArrayList<>();
		cities = addressMapper.getAllCities();
		return cities;
	}

	@Override
	public List<Area> getAllAreas() {
		List<Area> areas = new ArrayList<>();
		areas = addressMapper.getAllAreas();
		return areas;
	}
	

    @Override
    public ServiceType getServiceTypeById(Integer id)
    {
        return serviceTypeMapper.getServiceTypeById(id);
    }

    @Override
    public Rate getRateById(Integer id)
    {
        return rateMapper.getRateById(id);
    }

    @Override
    public Rate getRateForServiceAndVehicleType(Integer serviceTypeId, Integer vehicleTypeId)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("serviceTypeId", serviceTypeId);
        params.put("vehicleTypeId", vehicleTypeId);
        return rateMapper.getRateForServiceAndVehicleType(params);
    }
}
