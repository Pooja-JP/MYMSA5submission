package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

class listofemployeeTest {

	 @Test
	 @Order(3)
	    public void getListOfEmployeesTest(){

	        List<Employee> employees;
			try {
				employees = EmployeeRepository.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        Assertions.assertThat(employees.size()).isGreaterThan(0);

	    }

}
