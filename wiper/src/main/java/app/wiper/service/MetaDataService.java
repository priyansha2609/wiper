package app.wiper.service;

import java.util.List;

import app.wiper.domain.core.Rate;
import app.wiper.domain.type.ServiceType;
import org.springframework.stereotype.Service;

import app.wiper.domain.type.Area;
import app.wiper.domain.type.City;
import app.wiper.domain.type.EntityType;
import app.wiper.domain.type.ServiceSuperType;
import app.wiper.domain.type.VehicleType;

@Service
public interface MetaDataService {

	List<VehicleType> getAllVehicleTypes();
	
	List<EntityType> getAllEntityTypes();

    List<ServiceType> getAllServiceTypes();
    List<ServiceSuperType>getAllServiceSuperTypes();
    List<Rate> getAllRates();
	VehicleType getVehicleTypeById(Integer id);
	
	EntityType getEntityTypeById(Integer id);
    ServiceType getServiceTypeById(Integer id);
    Rate getRateById(Integer id);
    Rate getRateForServiceAndVehicleType(Integer serviceTypeId, Integer vehicleTypeId);

	List<City> getAllCities();

	List<Area> getAllAreas();
}
