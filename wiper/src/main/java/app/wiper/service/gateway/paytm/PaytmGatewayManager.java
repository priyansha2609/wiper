package app.wiper.service.gateway.paytm;

import app.wiper.domain.core.Order;
import app.wiper.domain.gateway.paytm.TransactionRequestParams;
import app.wiper.domain.gateway.paytm.TransactionResponseParams;
import app.wiper.mapper.interfaces.PaytmTxnResponseMapper;
import app.wiper.service.gateway.GatewayManager;
import app.wiper.domain.gateway.paytm.PaytmConstants.PAYLOAD_PARAMETERS;
import app.wiper.domain.gateway.paytm.PaytmConstants.MERCHANT_CONSTS;
import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
@Log4j2
public class PaytmGatewayManager implements GatewayManager
{
    @Autowired
    private PaytmTxnResponseMapper responseMapper;

    @Override
    public void makePayment(Order order)
    {

    }

    public boolean validateAndPersistResponse(final TransactionResponseParams responseParams)
    {
        boolean isValidResponse = validateChecksum(responseParams);
        if (isValidResponse) {
            upsertPaytmResponse(responseParams);
            log.info("Validated response and updated in DB");
        }

        return isValidResponse;
    }

    public String generateChecksum(final TransactionRequestParams transactionRequestParams)
    {
        TreeMap<String,String> paramMap = new TreeMap<String,String>();
        paramMap.put(PAYLOAD_PARAMETERS.MERCHANT_KEY.getValue(), MERCHANT_CONSTS.MERCHANT_ID.getValue());
        paramMap.put(PAYLOAD_PARAMETERS.ORDER_ID.getValue(), transactionRequestParams.getOrderId());
        paramMap.put(PAYLOAD_PARAMETERS.CUSTOMER_ID.getValue(), transactionRequestParams.getCustId());
        paramMap.put(PAYLOAD_PARAMETERS.INDUSTRY_TYPE_ID.getValue(), MERCHANT_CONSTS.INDUSTRY_TYPE_ID.getValue());
        paramMap.put(PAYLOAD_PARAMETERS.CHANNEL_ID.getValue(), MERCHANT_CONSTS.CHANNEL_ID.getValue());
        paramMap.put(PAYLOAD_PARAMETERS.TXN_AMOUNT.getValue(), String.valueOf(transactionRequestParams.getTxnAmount()));
        paramMap.put(PAYLOAD_PARAMETERS.WEBSITE.getValue(), MERCHANT_CONSTS.WEBSITE_STAGING.getValue());
        paramMap.put(PAYLOAD_PARAMETERS.EMAIL.getValue(), transactionRequestParams.getEmail());
        paramMap.put(PAYLOAD_PARAMETERS.PHONE.getValue(), transactionRequestParams.getMobile());
        paramMap.put(PAYLOAD_PARAMETERS.CALLBACK_URL.getValue(),
                MERCHANT_CONSTS.CALLBACK_URL_STAGING.getValue() + transactionRequestParams.getOrderId());

        String checkSum = "";
        try{
            checkSum =
                CheckSumServiceHelper.getCheckSumServiceHelper()
                    .genrateCheckSum(MERCHANT_CONSTS.MERCHANT_KEY.getValue(), paramMap);
            paramMap.put(PAYLOAD_PARAMETERS.CHECKSUM_HASH.getValue(), checkSum);

            log.info("Paytm Payload: " + paramMap);

        }catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return checkSum;
    }

    private boolean validateChecksum(final TransactionResponseParams transactionResponseParams)
    {
        boolean isValideChecksum = false;
        try{

            isValideChecksum =
                    CheckSumServiceHelper.getCheckSumServiceHelper()
                                         .verifycheckSum(MERCHANT_CONSTS.MERCHANT_KEY.getValue(),
                                                         transactionResponseParams.getResponseAsMap(),
                                                         transactionResponseParams.getChecksumHash());

            log.info("Paytm response params: " + transactionResponseParams +
                            " isValidCheckSum: " + isValideChecksum);

            // if checksum is validated Kindly verify the amount and status
            // if transaction is successful
            // kindly call Paytm Transaction Status API and verify the transaction amount and status.
            // If everything is fine then mark that transaction as successful into your DB.


        }catch(Exception e){
            e.printStackTrace();
        }

        return isValideChecksum;
    }

    private String upsertPaytmResponse(TransactionResponseParams responseParams)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("transactionResponseParams", responseParams);
        responseMapper.upsertTxnResponse(params);
        return params.get("txnId").toString();
    }

    public String insertPaytmResponse(TransactionResponseParams responseParams)
    {
        return upsertPaytmResponse(responseParams);
    }

    public String updatePaytmResponse(TransactionResponseParams responseParams)
    {
        return upsertPaytmResponse(responseParams);
    }
}
