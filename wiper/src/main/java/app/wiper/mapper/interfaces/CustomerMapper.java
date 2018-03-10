package app.wiper.mapper.interfaces;

import java.util.Map;

import app.wiper.domain.core.Customer;

public interface CustomerMapper {
	
	Customer getCustomerById(Integer id);
	
	Integer insertCustomerBasicData(Map<String, Object> params);

}
