package app.wiper.mapper.interfaces;

import app.wiper.domain.core.ServiceDetails;

import java.util.List;
import java.util.Map;

public interface ServiceDetailsMapper {
    List<ServiceDetails> getServiceDetailsForVehicle(Integer vehicleId);
    ServiceDetails getServiceDetailsById(Integer serviceDetailsId);
    List<ServiceDetails> getServiceDetailsForOrderId(Integer orderId);
    Integer upsertServiceDetails(Map<String, Object> params);
    List<ServiceDetails> getAllActiveSubscriptions();
}
