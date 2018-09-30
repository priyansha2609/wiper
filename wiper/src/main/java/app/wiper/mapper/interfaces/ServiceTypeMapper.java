package app.wiper.mapper.interfaces;

import app.wiper.domain.type.ServiceType;

import java.util.List;
import java.util.Map;


public interface ServiceTypeMapper
{
    List<ServiceType> getAllServiceTypes();
    ServiceType getServiceTypeById(Integer serviceTypeId);
    Integer upsertServiceType(Map<String, Object> params);
    List<ServiceType> getServiceTypesBySuperTypeById(Integer serviceSuperTypeId);
    List<ServiceType> getEligibleServiceTypesForCoupon(Integer coupon_id);
}
