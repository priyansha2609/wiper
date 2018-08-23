package app.wiper.mapper.interfaces;

import app.wiper.domain.type.ServiceSuperType;

import java.util.List;


public interface ServiceSuperTypeMapper
{
    List<ServiceSuperType> getAllServiceSuperTypes();
    ServiceSuperType getServiceTypeById(Integer serviceTypeId);
}
