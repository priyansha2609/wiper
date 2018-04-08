package app.wiper.domain.type;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionStatus implements Serializable
{
    Integer transactionStatusId;
    String name;
    String description;
    Boolean isActive;
    Integer orderId;
}
