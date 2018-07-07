package app.wiper.mapper.interfaces;

import app.wiper.domain.type.SubscriptionType;
import app.wiper.util.Constants.SUBSCRIPTION_TYPE;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubscriptionTypeMapper
{
    SubscriptionType getSubscriptionTypeById(Integer subscriptionTypeId);
    List<SubscriptionType> getAllSubscriptionTypes();
    SubscriptionType getSubscriptionOfType(SUBSCRIPTION_TYPE subscription_type);
}
