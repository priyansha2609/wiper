package app.wiper.mapper.interfaces;

import java.util.Map;

import app.wiper.domain.core.CorrespondenceAddress;
import app.wiper.domain.core.VehicleAddress;
import app.wiper.domain.type.Area;
import app.wiper.domain.type.City;

public interface AddressMapper {

	VehicleAddress getAddressForVehicle(Integer vehicleId);
	
	Area getAreaById(Integer areaId);
	
	City getCityById(Integer cityId);
	
	CorrespondenceAddress getCorrespondenceAddressByCustomerId(Integer customerId);
	
	void insertAddressForCustomer(Map<String, Object> params);

}
