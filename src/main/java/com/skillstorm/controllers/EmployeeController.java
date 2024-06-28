package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Employee;
import com.skillstorm.dtos.PaginatedResponse;

import com.skillstorm.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
    @GetMapping("/pagination")
    public PaginatedResponse<Employee> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
    	
    	// Build Pageable from query parameters
        Pageable pageable = PageRequest.of(page, size);
        
        // Called our method from PAndSRepo
        Page<Employee> employeePage;
        employeePage = service.getAllEmployees(pageable);

        // Build our DTO
        return new PaginatedResponse<>(
                employeePage.getNumber(),
                employeePage.getSize(),
                employeePage.getTotalElements(),
                employeePage.getTotalPages(),
                employeePage.isLast(),
                employeePage.getContent()
        );
    }
	
	//	@GetMapping
	//	public Iterable<Employee> getAllDepartments() {
	//		return service.getAllEmployees();
	//	}
	//	
	//	@PostMapping
	//	public Employee createEmployee(@RequestBody Employee employee) {
	//		return service.createEmployee(employee);
	//	}
}
