package app.wiper.service.impl;

import app.wiper.domain.type.TransactionStatus;
import app.wiper.mapper.interfaces.TransactionStatusMapper;
import app.wiper.service.TransactionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionStatusServiceImpl implements TransactionStatusService
{
    @Autowired
    private TransactionStatusMapper transactionStatusMapper;

    @Override
    public TransactionStatus getTransactionStatusById(Integer transactionStatusId)
    {
        return transactionStatusMapper.getTransactionStatusById(transactionStatusId);
    }
}
