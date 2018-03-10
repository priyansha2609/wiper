package app.wiper.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.wiper.domain.core.CorrespondenceAddress;
import app.wiper.domain.core.Customer;
import app.wiper.mapper.interfaces.AddressMapper;
import app.wiper.mapper.interfaces.CustomerMapper;
import app.wiper.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;

	@Autowired
	AddressMapper addressMapper;
	@Override
	public Customer getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return customerMapper.getCustomerById(customerId);
	}
	
	@Override
	public void insertAddressForCustomer(Integer customerId, CorrespondenceAddress corrAdd) {
		Map<String, Object> params = new HashMap<>();
        params.put("customerId", customerId);
        params.put("address", corrAdd);
        addressMapper.insertAddressForCustomer(params);
	}

	@Override
	public void insertCustomerBasicData(Customer customer) {
		Map<String, Object> params = new HashMap<>();
        params.put("customer", customer);
        customerMapper.insertCustomerBasicData(params);
	}
}
