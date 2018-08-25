package app.wiper.domain.type;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ServiceType
{
    Integer serviceTypeId;
    String name;
    String description;
    Boolean isActive;
    Integer orderId;
    SubscriptionType subscriptionType;
    String imageUrl;
}
