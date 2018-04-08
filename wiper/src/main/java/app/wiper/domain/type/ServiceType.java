package app.wiper.domain.type;

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
}
