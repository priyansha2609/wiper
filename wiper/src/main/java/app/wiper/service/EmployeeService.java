package app.wiper.service;

import org.springframework.stereotype.Service;

import app.wiper.domain.core.Employee;


@Service
public interface EmployeeService {
	
	Employee getEmployeeById(Integer employeeId);
	
	public void insertEmployee(Employee employee);
}
