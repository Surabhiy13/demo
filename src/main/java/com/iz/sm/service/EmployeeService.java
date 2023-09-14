package com.iz.sm.service;

import java.util.List;
import java.util.Optional;

import com.iz.sm.entities.Employee;

public interface EmployeeService {
	//get employee by id
	public Optional<Employee> getEmployeeById(long id);
	//get all employee
	public List<Employee> getAllEmployee();
	 //to create employee
	public Employee addEmployee(Employee emp);
	//update employee
	public Boolean updateEmployee(long id,Employee e);
	//delete employee
	public Boolean deleteEmployeeById(long id);
	
	
	

}
