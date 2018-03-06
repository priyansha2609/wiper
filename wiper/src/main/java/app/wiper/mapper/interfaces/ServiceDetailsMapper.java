package app.wiper.mapper.interfaces;

import java.util.List;

import app.wiper.domain.core.ServiceDetails;

public interface ServiceDetailsMapper {
	
	List<ServiceDetails> getServiceDetailsForVehicle(Integer vehicleId);

}
