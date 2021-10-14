package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

class updateemployeeTest {

	    @Test
	    @Order(4)
	    @Rollback(value = false)
	    public void updateEmployeeTest(){

	        Employee employee = new Employee();

	        employee.setEmailId("pooajp@gmail.com");

	        Employee employeeUpdated = new Employee();

	        Assertions.assertThat(employeeUpdated.getEmailId()).isEqualTo("ram@gmail.com");

	    }

}
