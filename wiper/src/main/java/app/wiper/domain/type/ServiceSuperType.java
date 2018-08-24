package app.wiper.domain.type;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceSuperType implements Serializable
{
    Integer serviceSuperTypeId;
    String name;
    String description;
    String imageUrl;
    ServiceType serviceTypes;
}

