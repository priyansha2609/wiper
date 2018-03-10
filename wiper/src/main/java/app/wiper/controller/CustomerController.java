package app.wiper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.wiper.domain.core.Customer;
import app.wiper.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/getCustomerById")
	public Customer getCustomerById(@RequestParam Integer customerId){
		return customerService.getCustomerById(customerId);
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/insertCustomer")
	public void insertCustomer(@RequestBody Customer customer){
		 customerService.insertCustomer(customer);
	}
}
