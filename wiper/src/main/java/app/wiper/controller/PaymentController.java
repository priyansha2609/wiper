package app.wiper.controller;

import app.wiper.domain.core.OrderCart;
import app.wiper.domain.core.Payment;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.service.OrderCartService;
import app.wiper.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderCartService orderCartService;

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

    @RequestMapping(method=RequestMethod.POST, value="/createOrder")
    public Integer createOrder(@RequestBody OrderCart orderCart)
    {
        return orderCartService.processOrderCart(orderCart);
    }
}
