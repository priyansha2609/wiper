package app.wiper.mapper.interfaces;

import java.util.List;
import java.util.Map;

import app.wiper.domain.core.Employee;
import app.wiper.domain.core.EmployeeLocation;

public interface EmployeeMapper {
	
	Employee getEmployeeById(Integer id);
	Integer insertBasicDataForEmployee(Map<String, Object> params);
	void insertLocationForEmployee(Map<String, Object> params);
	
	
	List<EmployeeLocation> getLocationsForEmployee(Integer employeeId);
		
}
