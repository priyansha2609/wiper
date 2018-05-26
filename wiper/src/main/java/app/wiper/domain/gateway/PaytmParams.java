package app.wiper.domain.gateway;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaytmParams
{
    private String orderId;
    private String custId;
    private double txnAmount;
    private String email;
    private String mobile;
}
