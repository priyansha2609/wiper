package app.wiper.controller;

import app.wiper.domain.core.Rate;
import app.wiper.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RateController
{
    @Autowired
    private RateService rateService;

    @RequestMapping(method = RequestMethod.POST, value = "/insertRate")
    public void insertRate(@RequestBody Rate rate)
    {
        rateService.insertRate(rate);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateRate")
    public void updateRate(@RequestBody Rate rate)
    {
        rateService.updateRate(rate);
    }
}
