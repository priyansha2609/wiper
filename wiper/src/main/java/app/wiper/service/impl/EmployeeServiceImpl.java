package app.wiper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.wiper.domain.core.Employee;
import app.wiper.mapper.interfaces.EmployeeMapper;
import app.wiper.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public Employee getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeMapper.getEmployeeById(employeeId);
	}
}
