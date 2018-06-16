package app.wiper.controller;

import app.wiper.domain.gateway.paytm.PaytmConstants;
import app.wiper.domain.gateway.paytm.TransactionRequestParams;
import app.wiper.domain.gateway.paytm.TransactionResponseParams;
import app.wiper.service.gateway.paytm.PaytmGatewayManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
@Log4j2
public class PaytmChecksumController
{

    @Autowired
    private PaytmGatewayManager paytmGatewayManager;

    @RequestMapping(method=RequestMethod.POST, value="/getPaytmChecksum")
    public Map<String, String> getPaytmChecksum(@RequestBody TransactionRequestParams transactionRequestParams)
    {
        String checkSum = paytmGatewayManager.generateChecksum(transactionRequestParams);
        Map<String, String> checkSumMap =  new HashMap<>();
        checkSumMap.put(PaytmConstants.PAYLOAD_PARAMETERS.CHECKSUM_HASH.getValue(), checkSum);
        System.out.println(checkSumMap);
        return checkSumMap;
    }

    @RequestMapping(method=RequestMethod.POST, value="/paytmRes",
                    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String validatePaytmResponse(
            @RequestBody TransactionResponseParams transactionResponseParams)
    {
        log.info("PAYTM RESPONSE "+ transactionResponseParams.getOrderId());

        boolean isValidResponse =
                paytmGatewayManager.validateAndPersistResponse(transactionResponseParams);

        return "Transaction " + (isValidResponse ? "successful: " : "failed: ")
                + transactionResponseParams;
    }
}
