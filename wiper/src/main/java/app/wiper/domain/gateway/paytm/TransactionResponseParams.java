package app.wiper.domain.gateway.paytm;

import lombok.Getter;
import lombok.Setter;

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
}
