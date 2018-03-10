package app.wiper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.wiper.domain.core.Employee;
import app.wiper.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/getEmployeeById")
	public Employee getEmployeeById(@RequestParam Integer id){
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/insertEmployee")
	public void insertEmployee(@RequestBody Employee employee){
		 employeeService.insertEmployee(employee);
	}

}
