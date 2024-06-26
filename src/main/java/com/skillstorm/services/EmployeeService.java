package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Employee;

import com.skillstorm.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	// create a new employee
	public Employee createEmployee(Employee employee) {
		if (!repo.existsById(employee.getEmployeeId()))
			return null;
		return repo.save(employee);
	}
	
	// get all employees
	public Iterable<Employee> getAllEmployees() {
		return repo.findAll();
	}
	
	// get an employee by id
	
	// update an employee
	
	// delete an employee by id

}
