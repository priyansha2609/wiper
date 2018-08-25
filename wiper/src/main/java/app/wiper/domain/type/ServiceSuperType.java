package app.wiper.domain.type;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceSuperType
{
    Integer serviceSuperTypeId;
    String name;
    String description;
    String imageUrl;
    List<ServiceType> serviceTypes;
}

