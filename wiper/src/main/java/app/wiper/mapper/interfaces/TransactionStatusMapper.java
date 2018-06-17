package app.wiper.mapper.interfaces;

import app.wiper.domain.type.TransactionStatus;
import app.wiper.util.Constants.TRANSACTION_STATUS;

public interface TransactionStatusMapper
{
    TransactionStatus getTransactionStatusById(TRANSACTION_STATUS transaction_status);
}
