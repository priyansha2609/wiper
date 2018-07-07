package app.wiper.controller;

import java.util.List;

import app.wiper.domain.core.Rate;
import app.wiper.domain.type.*;
import app.wiper.service.MetaDataService;
import app.wiper.service.ServiceSlotService;
import app.wiper.service.SubscriptionTypeService;
import app.wiper.service.TransactionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetadataController {

	@Autowired
	private MetaDataService metaDataService;


    @Autowired
    private TransactionStatusService transactionStatusService;

    @Autowired
    private ServiceSlotService serviceSlotService;

    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

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
	
	@RequestMapping("/getAllCities")
	public List<City> getAllCities(){
		return metaDataService.getAllCities();
	}
	
	@RequestMapping("/getAllAreas")
	public List<Area> getAllAreas(){
		return metaDataService.getAllAreas();
	}
	

    @RequestMapping("/getTransactionStatusById")
    public TransactionStatus getTransactionStatusById(@RequestParam Integer transactionStatusId)
    {
        return transactionStatusService.getTransactionStatusById(transactionStatusId);
    }

    @RequestMapping("/getAllServiceSlots")
    public List<ServiceSlot> getAllServiceSlots()
    {
        return serviceSlotService.getAllServiceSlots();
    }

    @RequestMapping("/getServiceSlotById")
    public ServiceSlot getServiceSlotById(@RequestParam Integer slotId)
    {
        return serviceSlotService.getServiceSlotById(slotId);
    }

    @RequestMapping("/getSubscriptionTypeById")
    public SubscriptionType getSubscriptionType(@RequestParam Integer subscriptionTypeId)
    {
        return subscriptionTypeService.getSubscriptionTypeById(subscriptionTypeId);
    }

    @RequestMapping("/getAllSubscriptionTypes")
    public List<SubscriptionType> getAllSubscriptionTypes()
    {
        return subscriptionTypeService.getAllSubscriptionTypes();
    }
}
