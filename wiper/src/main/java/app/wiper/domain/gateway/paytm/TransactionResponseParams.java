package app.wiper.domain.gateway.paytm;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TransactionResponseParams
{
    private String orderId;
    private String txnAmount;
    private String currency;
    private String txnId;
    private String bankTxnId;
    private String status;
    private String responseCode;
    private String responseMessage;
    private String txnDate;
    private String gatewayName;
    private String bankName;
    private String paymentMode;
    private String checkSumHash;

    public TransactionResponseParams(final Map<String, String> params)
    {
        orderId = params.getOrDefault("", "");
        txnAmount = params.getOrDefault("", "");
        currency = params.getOrDefault("", "");
        txnId = params.getOrDefault("", "");
        bankTxnId = params.getOrDefault("", "");
        status = params.getOrDefault("", "");
        responseCode = params.getOrDefault("", "");
        responseMessage = params.getOrDefault("", "");
        txnDate = params.getOrDefault("", "");
        gatewayName = params.getOrDefault("", "");
        bankName = params.getOrDefault("", "");
        paymentMode = params.getOrDefault("","");
        checkSumHash = params.getOrDefault("", "");
    }
}
