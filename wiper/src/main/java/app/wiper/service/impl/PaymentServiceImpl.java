package app.wiper.service.impl;

import app.wiper.domain.core.Payment;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.domain.type.TransactionStatus;
import app.wiper.mapper.interfaces.PaymentMapper;
import app.wiper.mapper.interfaces.ServiceDetailsMapper;
import app.wiper.mapper.interfaces.TransactionStatusMapper;
import app.wiper.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    PaymentMapper paymentMapper;

    @Autowired
    TransactionStatusMapper transactionStatusMapper;

    @Autowired
    ServiceDetailsMapper serviceDetailsMapper;

    @Override
    public Payment getPaymentById(Integer paymentId)
    {
        return paymentMapper.getPaymentById(paymentId);
    }

    @Override
    public List<ServiceDetails> getServiceDetailsForPaymentId(Integer paymentId)
    {
        return serviceDetailsMapper.getServiceDetailsForPaymentId(paymentId);
    }
}
