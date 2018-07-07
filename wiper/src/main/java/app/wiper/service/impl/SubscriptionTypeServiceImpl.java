package app.wiper.service.impl;

import app.wiper.domain.type.SubscriptionType;
import app.wiper.mapper.interfaces.SubscriptionTypeMapper;
import app.wiper.service.SubscriptionTypeService;
import app.wiper.util.Constants.SUBSCRIPTION_TYPE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService
{
    @Autowired
    private SubscriptionTypeMapper subscriptionTypeMapper;

    @Override
    public SubscriptionType getSubscriptionTypeById(Integer subscriptionTypeId)
    {
        return subscriptionTypeMapper.getSubscriptionTypeById(subscriptionTypeId);
    }

    @Override
    public List<SubscriptionType> getAllSubscriptionTypes()
    {
        return subscriptionTypeMapper.getAllSubscriptionTypes();
    }

    @Override
    public SubscriptionType getSubscriptionOfType(SUBSCRIPTION_TYPE subscriptionType)
    {
        return subscriptionTypeMapper.getSubscriptionOfType(subscriptionType);
    }
}
