package app.wiper.domain.type;

import app.wiper.util.Constants.SUBSCRIPTION_TYPE;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionType
{
    SUBSCRIPTION_TYPE subscriptionType;
    String name;
    String description;
    Boolean isActive;
    Integer orderId;
}
