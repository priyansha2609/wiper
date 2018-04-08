package app.wiper.mapper.interfaces;

import app.wiper.domain.core.ServiceDetails;
import app.wiper.domain.type.ServiceType;


public interface ServiceTypeMapper
{
    ServiceType getServiceTypeById(Integer serviceTypeId);
    Integer createNewSubscription(ServiceDetails serviceDetails);
}
