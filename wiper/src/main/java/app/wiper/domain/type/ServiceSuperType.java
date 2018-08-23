package app.wiper.domain.type;

import java.io.Serializable;

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
}

