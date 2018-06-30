package app.wiper.domain.type;

import app.wiper.util.Constants.SUBSCRIPTION_TYPE;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ServiceType implements Serializable
{
    Integer serviceTypeId;
    String name;
    String description;
    Boolean isActive;
    Integer orderId;
//    SUBSCRIPTION_TYPE subscriptionType;
    Integer subscriptionType;
}
