package app.wiper.service;

import org.springframework.stereotype.Service;

import app.wiper.domain.core.CorrespondenceAddress;
import app.wiper.domain.core.Customer;

@Service
public interface CustomerService {
	Customer getCustomerById(Integer customerId);
    Customer getCustomerByEmailId(String emailId);
	void insertAddressForCustomer(Integer cusotmerId, CorrespondenceAddress corrAdd);

	void insertCustomer(Customer customer) throws Exception;
}
