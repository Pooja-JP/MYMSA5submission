package net.javaguides.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.employeemanagerapp.repository.EmployeeRepository;
import com.mindtree.employeemanagerapp.service.EmployeeService;


@SpringBootTest
class SpringbootBackendApplicationTests {

	@Autowired
	private EmployeeService services;
	
	@MockBean
	private EmployeeRepository repository;
	
	@Test
	public void fetchEmployeeByIdTest()
	{
		//assertEquals(2,services.getEmployeeById(0).size());
	}
	

}
