package app.wiper.domain.type;

import java.io.Serializable;

import app.wiper.util.Constants.TRANSACTION_STATUS;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionStatus implements Serializable
{
    TRANSACTION_STATUS status;
    String name;
    String description;
    Boolean isActive;
    Integer orderId;
}
