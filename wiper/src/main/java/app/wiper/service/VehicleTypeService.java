package app.wiper.service;

import app.wiper.domain.type.VehicleType;
import org.springframework.stereotype.Service;

@Service
public interface VehicleTypeService
{
    Integer insertVehicleType(VehicleType vehicleType);
    Integer updateVehicleType(VehicleType vehicleType);
}
