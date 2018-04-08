package app.wiper.mapper.interfaces;

import app.wiper.domain.type.TransactionStatus;

import java.util.List;

public interface TransactionStatusMapper
{
    TransactionStatus getTransactionStatusById(Integer transactionStatusId);
}
