package app.wiper.domain.core;

import app.wiper.domain.type.ServiceType;
import app.wiper.domain.type.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Rate
{
    Integer rateId;
    ServiceType serviceType;
    VehicleType vehicleType;
    Double price;
    Date effectiveStartDate;
    Date effectiveEndDate;
    Boolean isActive;
}
