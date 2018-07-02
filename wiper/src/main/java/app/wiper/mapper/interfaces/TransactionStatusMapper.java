package app.wiper.mapper.interfaces;

import app.wiper.domain.type.TransactionStatus;
import app.wiper.util.Constants.TRANSACTION_STATUS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TransactionStatusMapper
{
    TransactionStatus getTransactionStatusById(Integer transactionStatusId);
    TransactionStatus getTransactionStatus(@Param("transactionStatus") TRANSACTION_STATUS transactionStatus);
}
