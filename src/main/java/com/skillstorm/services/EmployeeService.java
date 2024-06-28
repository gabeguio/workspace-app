package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.skillstorm.dtos.PaginatedResponse;
import com.skillstorm.models.Employee;

import com.skillstorm.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
    public PaginatedResponse<Employee> getAllEmployees(int page, int size) {
    	Pageable pageable = PageRequest.of(page, size);
    	Page<Employee> employeePage = repo.findAll(pageable);
    	return new PaginatedResponse<>(
                employeePage.getNumber(),
                employeePage.getSize(),
                employeePage.getTotalElements(),
                employeePage.getTotalPages(),
                employeePage.isLast(),
                employeePage.getContent());
    }
	
	//	// create a new employee
	//	public Employee createEmployee(Employee employee) {
	//		if (!repo.existsById(employee.getEmployeeId()))
	//			return null;
	//		return repo.save(employee);
	//	}
	//	
	//	// get all employees
	//	public Iterable<Employee> getAllEmployees() {
	//		return repo.findAll();
	//	}
		
	// get an employee by id
	
	// update an employee
	
	// delete an employee by id

}
