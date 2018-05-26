package app.wiper.service.gateway.paytm;

import app.wiper.domain.core.Payment;
import app.wiper.domain.gateway.PaytmParams;
import app.wiper.service.gateway.GatewayManager;
import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class PaytmGatewayManager implements GatewayManager
{
    //Below parameters provided by Paytm

    private static String MID = "WiperS96733632560363";
    private static String MercahntKey = "8u@fS6NCYe@Z@7d%";
    private static String INDUSTRY_TYPE_ID = "Retail";
    private static String CHANNLE_ID = "WAP";
    private static String WEBSITE = "APPSTAGING";
    private static String CALLBACK_URL = "https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=";
    @Override
    public void makePayment(Payment payment)
    {

    }

    public String generateChecksum(final PaytmParams paytmParams)
    {
        TreeMap<String,String> paramMap = new TreeMap<String,String>();
        paramMap.put("MID" , MID);
        paramMap.put("ORDER_ID" , paytmParams.getOrderId());
        paramMap.put("CUST_ID" , paytmParams.getCustId());
        paramMap.put("INDUSTRY_TYPE_ID" , INDUSTRY_TYPE_ID);
        paramMap.put("CHANNEL_ID" , CHANNLE_ID);
        paramMap.put("TXN_AMOUNT", String.valueOf(paytmParams.getTxnAmount()));
        paramMap.put("WEBSITE" , WEBSITE);
        paramMap.put("EMAIL" , paytmParams.getEmail());
        paramMap.put("MOBILE_NO" , paytmParams.getMobile());
        paramMap.put("CALLBACK_URL" , CALLBACK_URL+paytmParams.getOrderId());
        System.out.println("Paytm Payload: "+ paramMap);
        String checkSum = "";
        try{
            checkSum =  CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MercahntKey, paramMap);
            paramMap.put("CHECKSUMHASH" , checkSum);

            System.out.println("Paytm Payload: "+ paramMap);

        }catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return checkSum;
    }

    public boolean validateChecksum(final Payment payment)
    {
        String paytmChecksum = "";

        Map<String, String> mapData = new  TreeMap<String,String>();

        TreeMap<String, String> paytmParams = new  TreeMap<String,String>();

        for (Map.Entry<String, String> entry : mapData.entrySet())
        {
            if(entry.getKey().equals("CHECKSUMHASH")){
                paytmChecksum = entry.getKey();
            }else{
                paytmParams.put(entry.getKey(), entry.getValue());
            }
        }


        boolean isValideChecksum = false;
        try{

            isValideChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(MercahntKey, paytmParams, paytmChecksum);

            System.out.println(isValideChecksum);

            // if checksum is validated Kindly verify the amount and status
            // if transaction is successful
            // kindly call Paytm Transaction Status API and verify the transaction amount and status.
            // If everything is fine then mark that transaction as successful into your DB.


        }catch(Exception e){
            e.printStackTrace();
        }
        return isValideChecksum;
    }
}
