package com.mindtree.employeemanagerapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getemployeelist")
	public List<Employee> fetchEmployeeList(){
		List<Employee> employee = new ArrayList<Employee>(); 
		//logic to fetch list from database
		employee = EmployeeService.getAllEmployees();
		return employee;
	}	
	@PostMapping("/addemployee")
	public Employee saveEmployee(@RequestBody Employee employee){		
		return employeeService.createEmployee(employee);
	}
	@GetMapping("/getemployeebyid/{id}")
	public Employee fetchEmployeeById(@PathVariable int id){		
		return employeeService.getEmployeeById(id).get();		
	}
	@DeleteMapping("/deleteemployeebyid/{id}")
	public String deleteEmployeeById(@PathVariable int id){		
		return EmployeeService.deleteEmployeeById(id);
	}	
	
	
	
	
}
