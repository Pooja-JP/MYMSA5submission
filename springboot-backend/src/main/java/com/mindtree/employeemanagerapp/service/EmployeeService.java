package com.mindtree.employeemanagerapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindtree.employeemanagerapp.exception.ResourceNotFoundException;
import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

@Service
public interface EmployeeService {
	public final EmployeeRepository repo = null;	
	
	public static  List<Employee> getAllEmployees(){
		return repo.findAll();
	}	
	public default  Employee createEmployee(Employee employee){
		return repo.save(employee);
	}	
	public default  Optional<Employee> getEmployeeById(int id){
		return repo.findById((long) id);
	}	
	public static String deleteEmployeeById(int id)
	{
		String result;
		try
		{
			repo.deleteById((long) id);
			result="Employee deleted successfully";
		}
		catch(Exception e)
		{
			result="Employee with id is not deleted";
		}
		return result;		 
	}
	Employee updateEmployeeByIdWithNewEmployee(Long id, Employee employee);
	Employee getEmployeeById(Long id) throws ResourceNotFoundException;
	Object getEmployeeList();


	/**
	 * @param id
	 * @return Employee with given id
	 */

}
