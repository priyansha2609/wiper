package app.wiper.service;

import app.wiper.domain.type.ServiceType;
import org.springframework.stereotype.Service;

@Service
public interface ServiceTypeService
{
    Integer insertServiceType(ServiceType serviceType);
    Integer updateServiceType(ServiceType serviceType);
}
