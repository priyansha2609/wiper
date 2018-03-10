package app.wiper.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.wiper.domain.core.CorrespondenceAddress;
import app.wiper.domain.core.Employee;
import app.wiper.domain.core.EmployeeLocation;
import app.wiper.mapper.interfaces.AddressMapper;
import app.wiper.mapper.interfaces.EmployeeMapper;
import app.wiper.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	AddressMapper addressMapper;
	
	@Override
	public Employee getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee emp =  employeeMapper.getEmployeeById(employeeId);
		return emp;
	}
	

	public void insertEmployee(Employee employee) {
		Integer employeeId = insertBasicDataForEmployee(employee);
		employee.setEmployeeId(employeeId);
		insertAddressForEmployee(employeeId, employee.getCorrespondenceAddress());
		insertLocationsForEmployee(employeeId,employee.getEmployeeLocations());
	}
	
	public void insertAddressForEmployee(Integer employeeId, CorrespondenceAddress corrAdd) {
		Map<String, Object> params = new HashMap<>();
        params.put("employeeId", employeeId);
        params.put("address", corrAdd);
        addressMapper.insertAddressForEmployee(params);
	}
	
	public void insertLocationsForEmployee(Integer employeeId, List<EmployeeLocation> empLocations) {
		for(EmployeeLocation empLocation : empLocations) {
			insertLocationForEmployee(employeeId,empLocation);
		}
	}
	
	public void insertLocationForEmployee(Integer employeeId, EmployeeLocation employeeLocation) {
		Map<String, Object> params = new HashMap<>();
        params.put("employeeId", employeeId);
        params.put("employeeLocation", employeeLocation);
        employeeMapper.insertLocationForEmployee(params);
	}
	
	
	public Integer insertBasicDataForEmployee(Employee employee) {
		Map<String, Object> params = new HashMap<>();
        params.put("employee", employee);
        employeeMapper.insertBasicDataForEmployee(params);
        Integer employeeId = (Integer) params.get("employeeId");
        return employeeId;       
	}
	
}
