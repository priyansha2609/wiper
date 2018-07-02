package app.wiper.service;

import app.wiper.domain.type.TransactionStatus;
import org.springframework.stereotype.Service;

@Service
public interface TransactionStatusService
{
    TransactionStatus getTransactionStatusById(Integer transactionStatusId);
}
