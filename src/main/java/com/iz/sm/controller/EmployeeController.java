package com.iz.sm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iz.sm.constants.AppConstants;
import com.iz.sm.entities.Employee;
import com.iz.sm.exception.EmployeeNotFound;
import com.iz.sm.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	// to add employee
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
		Employee emp = employeeServiceImpl.addEmployee(e);
		return ResponseEntity.status(HttpStatus.CREATED).body(emp);
	}

	// to find employee by id
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Optional<Employee> emp = employeeServiceImpl.getEmployeeById(id);
		if (emp.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND).body(emp.get());
		} else {
			throw new EmployeeNotFound( );
		}
	}

	// to delete employee
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id) {
		if (employeeServiceImpl.deleteEmployeeById(id)) {
			

			return ResponseEntity.status(HttpStatus.OK).body(AppConstants.DELETED);

		} else
			throw new EmployeeNotFound();
	}

	// to update employee
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployeeById(@PathVariable long id, @RequestBody Employee e) {
		if (employeeServiceImpl.updateEmployee(id, e)) {
			

			return ResponseEntity.status(HttpStatus.OK).body(AppConstants.UPDATED);

		} else {
			throw new EmployeeNotFound();
		}
	}

	// to get all employee
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> e = employeeServiceImpl.getAllEmployee();
		return ResponseEntity.ok(e);
	}

}
