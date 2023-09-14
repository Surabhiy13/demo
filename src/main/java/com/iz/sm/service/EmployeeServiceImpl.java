package com.iz.sm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iz.sm.entities.Employee;
import com.iz.sm.exception.EmployeeNotFound;
import com.iz.sm.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		employeeRepo.findById(id);
		
      return employeeRepo.findById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
		
	}

	@Override
	public Employee addEmployee(Employee emp) {
		employeeRepo.save(emp);
		return employeeRepo.save(emp);
	}

	@Override
	public Boolean updateEmployee(long id,Employee e) {
		Optional<Employee> emp=employeeRepo.findById(id);
		Employee emp1;
		if(emp.isPresent()) {
			 emp1=emp.get();
			emp1.setEmpName(e.getEmpName());
			emp1.setEmailId(e.getEmailId());
			emp1.setMobileNo(e.getMobileNo());
			employeeRepo.save(emp1);
			return emp.isPresent();
		}
		else
			return emp.isPresent();
	}

	@Override
	public Boolean deleteEmployeeById(long id) {
		Optional<Employee> emp=employeeRepo.findById(id);
		
		if(emp.isPresent()) {
			employeeRepo.delete(emp.get());
			
			return emp.isPresent();
		}
		return emp.isPresent();
	}
	

}
