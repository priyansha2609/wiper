package app.wiper.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/getVehicleTypeById")
	public VehicleType getVehicleTypeById(@RequestParam Integer id){
		return metaDataService.getVehicleTypeById(id);
	}
	
	@RequestMapping("/getEntityTypeById")
	public EntityType getEntityTypeById(@RequestParam("id") Integer id){
		return metaDataService.getEntityTypeById(id);
	}
	
}
