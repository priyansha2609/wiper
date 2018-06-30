package app.wiper.service.impl;

import java.util.HashMap;
import java.util.Map;

import app.wiper.domain.core.Credentials;
import app.wiper.mapper.interfaces.CredentialsMapper;
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

    @Autowired
    private CredentialsMapper credentialsMapper;

	@Override
	public Customer getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return customerMapper.getCustomerById(customerId);
	}

    @Override
    public Customer getCustomerByEmailId(String emailId)
    {
        Integer entityId = credentialsMapper.getCredentialsByEmailId(emailId);
        return customerMapper.getCustomerById(entityId);
    }

    public void insertAddressForCustomer(Integer customerId, CorrespondenceAddress corrAdd) {
		Map<String, Object> params = new HashMap<>();
        params.put("customerId", customerId);
        params.put("address", corrAdd);
        addressMapper.insertAddressForCustomer(params);
	}

	
	public Integer insertCustomerBasicData(Customer customer) {
		Map<String, Object> params = new HashMap<>();
        params.put("customer", customer);
        customerMapper.insertCustomerBasicData(params);
        Integer customerId = (Integer) params.get("customerId");
        return customerId;       
	}

    private void upsertCredentials(Customer customer)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("credentials", customer.getCredentials());
        params.put("entityTypeId", customer.getEntityType().getEntityTypeId());
        params.put("entityId", customer.getCustomerId());

        credentialsMapper.upsertCredentials(params);
    }

	@Override
	public void insertCustomer(Customer customer) {
		Integer customerId = insertCustomerBasicData(customer);
		customer.setCustomerId(customerId);

        upsertCredentials(customer);

		insertAddressForCustomer(customerId, customer.getCorrespondenceAddress());
	}
	
}
