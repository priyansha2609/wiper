package app.wiper.mapper.interfaces;

import java.util.Map;

import app.wiper.domain.core.Employee;

public interface EmployeeMapper {
	
	Employee getEmployeeById(Integer id);
	Integer insertBasicDataForEmployee(Map<String, Object> params);

}
