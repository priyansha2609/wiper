package app.wiper.controller;

import app.wiper.domain.type.VehicleType;
import app.wiper.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleTypeController
{
    @Autowired
    VehicleTypeService vehicleTypeService;

    @RequestMapping(method = RequestMethod.POST, value = "/insertVehicleType")
    Integer insertVehicleType(@RequestBody VehicleType vehicleType)
    {
        return vehicleTypeService.insertVehicleType(vehicleType);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateVehicleType")
    Integer updateVehicleType(@RequestBody VehicleType vehicleType)
    {
        return vehicleTypeService.updateVehicleType(vehicleType);
    }
}
