package app.wiper.controller;

import java.util.List;

import app.wiper.domain.core.Rate;
import app.wiper.domain.type.ServiceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.wiper.domain.type.EntityType;
import app.wiper.domain.type.VehicleType;
import app.wiper.service.MetaDataService;

@RestController
public class MetadataController {
	
	private static final Logger logger = LoggerFactory.getLogger(MetadataController.class);
	
	@Autowired
	private MetaDataService metaDataService;
	
	@RequestMapping("/getAllVehicleTypes")
	public List<VehicleType> getAllVehicleTypes(){
		return metaDataService.getAllVehicleTypes();
	}

	@RequestMapping("/getAllEntityTypes")
	public List<EntityType> getAllEntityTypes(){
		return metaDataService.getAllEntityTypes();
	}

    @RequestMapping("/getAllServiceTypes")
    public List<ServiceType> getAllServiceTypes()
    {
        return metaDataService.getAllServiceTypes();
    }

    @RequestMapping("/getAllRates")
    public List<Rate> getAllRates()
    {
        return metaDataService.getAllRates();
    }

    @RequestMapping("/getServiceTypeById")
    public ServiceType getServiceTypeById(@RequestParam Integer id)
    {
        return metaDataService.getServiceTypeById(id);
    }

    @RequestMapping("/getRateById")
    public Rate getRateById(@RequestParam Integer id)
    {
        return metaDataService.getRateById(id);
    }

    @RequestMapping("/getRateForServiceAndVehicleType")
    public Rate getRateForServiceAndVehicleType(@RequestParam("serviceTypeId") Integer serviceTypeId,
                                                @RequestParam("vehicleTypeId") Integer vehicleTypeId)
    {
        return metaDataService.getRateForServiceAndVehicleType(serviceTypeId, vehicleTypeId);
    }

	@RequestMapping("/getVehicleTypeById")
	public VehicleType getVehicleTypeById(@RequestParam Integer id){
		return metaDataService.getVehicleTypeById(id);
	}
	
	@RequestMapping("/getEntityTypeById")
	public EntityType getEntityTypeById(@RequestParam("id") Integer id){
		return metaDataService.getEntityTypeById(id);
	}
	
}
