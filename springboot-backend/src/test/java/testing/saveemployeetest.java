package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

class saveemployeetest {

	@Test
    @Order(1)
    @Rollback(value = false)
	void test() {

	        Employee employee = Employee.builder()
	                .firstName("Pooja")
	                .lastName("J P")
	                .email("poojajp@gmail.com")
	                .build();

	        EmployeeRepository.save(employee);

	        Assertions.assertThat(employee.getId()).isGreaterThan(0);
	    }
	}
