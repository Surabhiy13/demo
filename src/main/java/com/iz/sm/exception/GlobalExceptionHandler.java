package com.iz.sm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.iz.sm.constants.AppConstants;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=EmployeeNotFound.class)
	public  ResponseEntity<Object> EmployeeNotFoundException(EmployeeNotFound e){
		return new ResponseEntity<>(AppConstants.EMPLOYEE_NOT_FOUND, HttpStatus.NOT_FOUND);
	}

}
