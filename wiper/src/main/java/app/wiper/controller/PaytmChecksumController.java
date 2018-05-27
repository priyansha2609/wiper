package app.wiper.controller;

import app.wiper.domain.gateway.paytm.TransactionRequestParams;
import app.wiper.domain.gateway.paytm.TransactionResponseParams;
import app.wiper.service.gateway.paytm.PaytmGatewayManager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PaytmChecksumController
{
    @Autowired
    private PaytmGatewayManager paytmGatewayManager;

    @RequestMapping(method=RequestMethod.POST, value="/getPaytmChecksum")
    public Map<String, String> getPaytmChecksum(@RequestBody TransactionRequestParams transactionRequestParams)
    {
        String checkSum = paytmGatewayManager.generateChecksum(transactionRequestParams);
        Map<String, String> checkSumMap =  new HashMap<>();
        checkSumMap.put("checkSum", checkSum);
        System.out.println(checkSumMap);
        return checkSumMap;
    }

    @RequestMapping(method=RequestMethod.POST, value="/paytmRes")
    public void validatePaytmResponse(@RequestBody Map<String, String> transactionResponseParams)
    {
        System.out.println(transactionResponseParams);
        paytmGatewayManager.validateChecksum(transactionResponseParams);
    }
}
