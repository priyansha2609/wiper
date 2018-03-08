package app.wiper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.wiper.domain.core.Customer;
import app.wiper.mapper.interfaces.CustomerMapper;
import app.wiper.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;
	@Override
	public Customer getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return customerMapper.getCustomerById(customerId);
	}

}
