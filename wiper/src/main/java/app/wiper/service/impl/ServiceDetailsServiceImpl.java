package app.wiper.service.impl;

import app.wiper.domain.core.ServiceDetails;
import app.wiper.mapper.interfaces.ServiceDetailsMapper;
import app.wiper.service.ServiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceDetailsServiceImpl implements ServiceDetailsService
{
    @Autowired
    private ServiceDetailsMapper serviceDetailsMapper;

    @Override
    public List<ServiceDetails> getServiceDetailsForVehicle(Integer vehicleId)
    {
        return serviceDetailsMapper.getServiceDetailsForVehicle(vehicleId);
    }

    @Override
    public ServiceDetails getServiceDetailsById(Integer serviceDetailsId)
    {
        return serviceDetailsMapper.getServiceDetailsById(serviceDetailsId);
    }

    @Override
    public List<ServiceDetails> getServiceDetailsForOrderId(Integer orderId)
    {
        return serviceDetailsMapper.getServiceDetailsForOrderId(orderId);
    }

    private Integer upsertServiceDetails(ServiceDetails serviceDetails)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("serviceDetails", serviceDetails);
        serviceDetailsMapper.upsertServiceDetails(map);
        return (Integer) map.get("serviceDetailId");
    }

    @Override
    public Integer insertServiceDetails(ServiceDetails serviceDetails)
    {
        return upsertServiceDetails(serviceDetails);
    }

    @Override
    public Integer updateServiceDetails(ServiceDetails serviceDetails)
    {
        return upsertServiceDetails(serviceDetails);
    }

    @Override
    public List<ServiceDetails> getAllActiveSubscriptions()
    {
        return serviceDetailsMapper.getAllActiveSubscriptions();
    }
}
