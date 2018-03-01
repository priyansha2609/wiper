package app.wiper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.wiper.domain.core.Vehicle;
import app.wiper.service.VehicleService;

@RestController
public class VehicleController {

	
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping("/getVehicleById")
	public Vehicle getVehicleById(@RequestParam Integer vehicleId){
		return vehicleService.getVehicleById(vehicleId);
	}


}
