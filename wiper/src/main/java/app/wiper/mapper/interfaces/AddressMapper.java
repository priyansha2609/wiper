package app.wiper.mapper.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.wiper.domain.core.CorrespondenceAddress;
import app.wiper.domain.core.Location;
import app.wiper.domain.core.VehicleAddress;
import app.wiper.domain.type.Area;
import app.wiper.domain.type.City;

public interface AddressMapper {

	VehicleAddress getAddressForVehicle(Integer vehicleId);
	
	Area getAreaById(Integer areaId);
	
	City getCityById(Integer cityId);
	
	Location getLocationById(Integer locationId);
	
	CorrespondenceAddress getCorrespondenceAddressByCustomerId(Integer customerId);
	
	void insertAddressForCustomer(Map<String, Object> params);

	void insertAddressForEmployee(Map<String, Object> params);
	
	void insertAddressForVehicle(Map<String, Object> params);
	
	List<City> getAllCities();
	
	List<Area> getAllAreas();
	

}
