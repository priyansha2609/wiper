package app.wiper.controller;

import app.wiper.domain.gateway.PaytmParams;
import app.wiper.service.gateway.paytm.PaytmGatewayManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaytmChecksumController
{
    @Autowired
    private PaytmGatewayManager paytmGatewayManager;

    @RequestMapping(method=RequestMethod.POST, value="/getPaytmChecksum")
    public String getPaytmChecksum(@RequestBody PaytmParams paytmParams)
    {
        System.out.println(paytmParams);
        return paytmGatewayManager.generateChecksum(paytmParams);
    }
}
