package app.wiper.domain.gateway.paytm;

import app.wiper.domain.gateway.paytm.PaytmConstants.PAYLOAD_PARAMETERS;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.TreeMap;

@Getter
@Setter
@ToString
public class TransactionResponseParams
{
    @JsonProperty("MID")
    private String mId;

    @JsonProperty("ORDERID")
    private String orderId;

    @JsonProperty("TXNAMOUNT")
    private String txnAmount;

    @JsonProperty("CURRENCY")
    private String currency;

    @JsonProperty("TXNID")
    private String txnId;

    @JsonProperty("BANKTXNID")
    private String bankTxnId;

    @JsonProperty("STATUS")
    private String status;

    @JsonProperty("RESPCODE")
    private String responseCode;

    @JsonProperty("RESPMSG")
    private String responseMessage;

    @JsonProperty("TXNDATE")
    private String txnDate;

    @JsonProperty("GATEWAYNAME")
    private String gatewayName;

    @JsonProperty("BANKNAME")
    private String bankName;

    @JsonProperty("PAYMENTMODE")
    private String paymentMode;

    @JsonProperty("CHECKSUMHASH")
    private String checksumHash;

    /**
     * This method is specifically used to validate the checksum obtained in
     * the response from PayTM. Therefore we specifically return {@link TreeMap}.
     */
    public TreeMap<String, String> getResponseAsMap()
    {
        TreeMap<String, String> response = new TreeMap<>();

        response.put(PAYLOAD_PARAMETERS.MERCHANT_ID.getValue(), getMId());
        response.put(PAYLOAD_PARAMETERS.ORDER_ID.getValue(), getOrderId());
        response.put(PAYLOAD_PARAMETERS.TXN_AMOUNT.getValue(), getTxnAmount());
        response.put(PAYLOAD_PARAMETERS.CURRENCY.getValue(), getCurrency());
        response.put(PAYLOAD_PARAMETERS.TXN_ID.getValue(), getTxnId());
        response.put(PAYLOAD_PARAMETERS.BANK_TXN_ID.getValue(), getBankTxnId());
        response.put(PAYLOAD_PARAMETERS.STATUS.getValue(), getStatus());
        response.put(PAYLOAD_PARAMETERS.RESPONSE_CODE.getValue(), getResponseCode());
        response.put(PAYLOAD_PARAMETERS.RESPONSE_MSG.getValue(), getResponseMessage());
        response.put(PAYLOAD_PARAMETERS.TXN_DATE.getValue(), getTxnDate());
        response.put(PAYLOAD_PARAMETERS.GATEWAY_NAME.getValue(), getGatewayName());
        response.put(PAYLOAD_PARAMETERS.BANK_NAME.getValue(), getBankName());
        response.put(PAYLOAD_PARAMETERS.PAYMENT_MODE.getValue(), getPaymentMode());
        response.put(PAYLOAD_PARAMETERS.CHECKSUM_HASH.getValue(), getChecksumHash());

        return response;
    }
}
