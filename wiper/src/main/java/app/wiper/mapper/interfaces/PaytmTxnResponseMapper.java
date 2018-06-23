package app.wiper.mapper.interfaces;

import app.wiper.domain.gateway.paytm.TransactionResponseParams;

import java.util.List;
import java.util.Map;

public interface PaytmTxnResponseMapper
{
    TransactionResponseParams getTxnResponseForTxnId(String txnId);
    List<TransactionResponseParams> getAllTxnsResponseForOrderId(String orderId);
    Integer upsertTxnResponse(Map<String, Object> params);
}
