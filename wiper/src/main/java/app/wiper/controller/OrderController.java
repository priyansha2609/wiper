package app.wiper.controller;

import app.wiper.domain.core.OrderCart;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.service.OrderCartService;
import app.wiper.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderCartService orderCartService;

    @RequestMapping("/getOrderById")
    public OrderCart getOrderById(@RequestParam Integer orderId)
    {
        return orderCartService.getOrderByOrderId(orderId);
    }

    @RequestMapping("/getServiceDetailsForOrderId")
    public List<ServiceDetails> getServiceDetailsForOrderId(@RequestParam Integer orderId)
    {
        return orderService.getServiceDetailsForOrderId(orderId);
    }

    @RequestMapping(method=RequestMethod.POST, value="/createOrder")
    public Integer createOrder(@RequestBody OrderCart orderCart)
    {
        return orderCartService.processOrderCart(orderCart);
    }
}
