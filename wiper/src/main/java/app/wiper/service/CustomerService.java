package app.wiper.service;

import org.springframework.stereotype.Service;

import app.wiper.domain.core.CorrespondenceAddress;
import app.wiper.domain.core.Customer;

@Service
public interface CustomerService {
	Customer getCustomerById(Integer customerId);
	
	void insertAddressForCustomer(Integer cusotmerId, CorrespondenceAddress corrAdd);

	Integer insertCustomerBasicData(Customer customer);
}
