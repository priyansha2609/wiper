package app.wiper.service.impl;

import app.wiper.domain.type.ServiceType;
import app.wiper.mapper.interfaces.ServiceTypeMapper;
import app.wiper.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService
{
    @Autowired
    private ServiceTypeMapper serviceTypeMapper;

    @Override
    public Integer insertServiceType(ServiceType serviceType)
    {
        return upsertServiceType(serviceType);
    }

    @Override
    public Integer updateServiceType(ServiceType serviceType)
    {
        return upsertServiceType(serviceType);
    }

    private Integer upsertServiceType(ServiceType serviceType)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("serviceType", serviceType);
        serviceTypeMapper.upsertServiceType(params);
        return (Integer) params.get("serviceTypeId");
    }
}
