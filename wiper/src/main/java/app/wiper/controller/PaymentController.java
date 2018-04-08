package app.wiper.controller;

import app.wiper.domain.core.Payment;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/getPaymentById")
    public Payment getPaymentById(@RequestParam Integer paymentId)
    {
        return paymentService.getPaymentById(paymentId);
    }

    @RequestMapping("/getServiceDetailsForPaymentId")
    public List<ServiceDetails> getServiceDetailsForPaymentId(@RequestParam Integer paymentId)
    {
        return paymentService.getServiceDetailsForPaymentId(paymentId);
    }
}
