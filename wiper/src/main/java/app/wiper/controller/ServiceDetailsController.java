package app.wiper.controller;

import app.wiper.domain.core.ServiceDetails;
import app.wiper.service.ServiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceDetailsController
{
    @Autowired
    private ServiceDetailsService serviceDetailsService;

    @RequestMapping("/getServiceDetailsById")
    public ServiceDetails getServiceDetailsById(@RequestParam Integer serviceDetailId)
    {
        return serviceDetailsService.getServiceDetailsById(serviceDetailId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertServiceDetails")
    public void insertServiceDetails(@RequestBody ServiceDetails serviceDetails)
    {
        serviceDetailsService.insertServiceDetails(serviceDetails);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateServiceDetails")
    public void updateServiceDetails(@RequestBody ServiceDetails serviceDetails)
    {
        serviceDetailsService.updateServiceDetails(serviceDetails);
    }
    @RequestMapping("/getServiceDetailsForVehicle")
    public List<ServiceDetails> getServiceDetailsForVehicle(@RequestParam Integer vehicleId)
    {
        return serviceDetailsService.getServiceDetailsForVehicle(vehicleId);
    }
}
