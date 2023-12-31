package com.iz.sm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iz.sm.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
