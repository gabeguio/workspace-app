package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Employee;

import com.skillstorm.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public Iterable<Employee> getAllDepartments() {
		return service.getAllEmployees();
	}
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
}
