package app.wiper.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.wiper.domain.core.CorrespondenceAddress;
import app.wiper.domain.core.Customer;
import app.wiper.domain.type.Area;
import app.wiper.domain.type.City;
import app.wiper.mapper.interfaces.AddressMapper;
import app.wiper.mapper.interfaces.CustomerMapper;
import app.wiper.service.CustomerService;
import app.wiper.service.MetaDataService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;

	@Autowired
	AddressMapper addressMapper;
	
	@Autowired
	MetaDataService metaDataService;
	
	
	@Override
	public Customer getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return customerMapper.getCustomerById(customerId);
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
	
	@Override
	public void insertCustomer(Customer customer) throws Exception {
		CorrespondenceAddress correspondenceAddress = customer.getCorrespondenceAddress();
		if(isCityValid(correspondenceAddress) && isAreaValid(correspondenceAddress)) {
			
			Integer customerId = insertCustomerBasicData(customer);
			customer.setCustomerId(customerId);
			insertAddressForCustomer(customerId, customer.getCorrespondenceAddress());	
		}
		else throw new Exception("We don't service in this area.");
	}
	private Boolean isAreaValid(CorrespondenceAddress correspondenceAddress) {
		Boolean isAreaValid = false;
		if(correspondenceAddress != null && correspondenceAddress.getArea() != null) {
		Area customerArea = correspondenceAddress.getArea();
		List<Area> areas = metaDataService.getAllAreas();
		Area matchedArea = areas.stream()
                .filter(area -> area.getName().equalsIgnoreCase(customerArea.getName()))
                .findFirst().orElse(null);  
		if(matchedArea != null) {
			isAreaValid = true;
		}
		}
		return isAreaValid;
		
	}
	
	private Boolean isCityValid(CorrespondenceAddress correspondenceAddress) {
		Boolean isCityValid = false;
		if(correspondenceAddress != null && correspondenceAddress.getCity() != null) {
			City customerCity = correspondenceAddress.getCity();
			List<City> cities = metaDataService.getAllCities();
			City matchedCity = cities.stream()
	                .filter(city -> city.getName().equalsIgnoreCase(customerCity.getName()))
	                .findFirst().orElse(null);;  
			if(matchedCity != null) {
				isCityValid = true;
			}
			}
		
		return isCityValid;
	}
	
}
