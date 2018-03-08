package app.wiper.service;

import org.springframework.stereotype.Service;

import app.wiper.domain.core.Customer;

@Service
public interface CustomerService {
	Customer getCustomerById(Integer customerId);
}
