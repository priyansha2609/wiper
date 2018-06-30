package app.wiper.controller;

import app.wiper.domain.core.OrderCart;
import app.wiper.service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.wiper.domain.core.Customer;
import app.wiper.service.CustomerService;

import java.util.List;


@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

    @Autowired
    private OrderCartService orderCartService;

	@RequestMapping("/getCustomerById")
	public Customer getCustomerById(@RequestParam Integer customerId){
		return customerService.getCustomerById(customerId);
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/insertCustomer")
	public void insertCustomer(@RequestBody Customer customer) throws Exception{
		 customerService.insertCustomer(customer);
	}

    @RequestMapping("getAllOrdersForCustomer")
    public List<OrderCart> getAllOrdersForCustomer(@RequestParam Integer customerId)
    {
        return orderCartService.getAllOrdersForCustomer(customerId);
    }
}
