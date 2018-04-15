package app.wiper.service.impl;

import app.wiper.domain.core.Vehicle;
import app.wiper.domain.type.VehicleType;
import app.wiper.mapper.interfaces.VehicleTypeMapper;
import app.wiper.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService
{
    @Autowired
    private VehicleTypeMapper vehicleTypeMapper;

    @Override
    public Integer insertVehicleType(VehicleType vehicleType)
    {
        return upsertVehicleType(vehicleType);
    }

    @Override
    public Integer updateVehicleType(VehicleType vehicleType)
    {
        return upsertVehicleType(vehicleType);
    }

    private Integer upsertVehicleType(VehicleType vehicleType)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("vehicleType", vehicleType);
        vehicleTypeMapper.upsertVehicleType(params);
        return (Integer) params.get("vehicleTypeId");
    }
}
