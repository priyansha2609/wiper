package app.wiper.mapper.interfaces;

import java.util.List;
import java.util.Map;

import app.wiper.domain.core.ServiceDetails;

public interface ServiceDetailsMapper {
	
	List<ServiceDetails> getServiceDetailsForVehicle(Integer vehicleId);
    ServiceDetails getServiceDetailsById(Integer serviceDetailsId);
    List<ServiceDetails> getServiceDetailsForPaymentId(Integer paymentId);
    Integer upsertServiceDetails(Map<String, Object> params);
}
