package app.wiper.domain.gateway.paytm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestParams
{
    private String orderId;
    private String custId;
    private double txnAmount;
    private String email;
    private String mobile;
}
