package app.wiper.service;

import app.wiper.domain.core.ServiceDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceDetailsService
{
    List<ServiceDetails> getServiceDetailsForVehicle(Integer vehicleId);
    ServiceDetails getServiceDetailsById(Integer serviceDetailsId);
    List<ServiceDetails> getServiceDetailsForOrderId(Integer orderId);
    Integer insertServiceDetails(ServiceDetails serviceDetails);
    Integer updateServiceDetails(ServiceDetails serviceDetails);
}
