package app.wiper.controller;

import app.wiper.domain.type.ServiceType;
import app.wiper.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceTypeController
{
    @Autowired
    private ServiceTypeService serviceTypeService;

    @RequestMapping(method = RequestMethod.POST, value = "/insertServiceType")
    public void insertServiceType(@RequestBody ServiceType serviceType)
    {
        serviceTypeService.insertServiceType(serviceType);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateServiceType")
    public void updateServiceType(@RequestBody ServiceType serviceType)
    {
        serviceTypeService.updateServiceType(serviceType);
    }
}
