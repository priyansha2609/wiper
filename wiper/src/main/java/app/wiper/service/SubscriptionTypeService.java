package app.wiper.service;

import app.wiper.domain.type.SubscriptionType;
import app.wiper.util.Constants.SUBSCRIPTION_TYPE;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionTypeService
{
    SubscriptionType getSubscriptionTypeById(Integer subscriptionTypeId);
    List<SubscriptionType> getAllSubscriptionTypes();
    SubscriptionType getSubscriptionOfType(SUBSCRIPTION_TYPE subscriptionType);
}
