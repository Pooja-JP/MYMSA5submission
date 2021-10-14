package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

class deleteemployeeTest {

	@Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Employee employee;
		try {
			employee = EmployeeRepository.findById((long) 1).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        EmployeeRepository.delete(employee);
        Employee employee1 = null;
        Optional<Employee> optionalEmployee = EmployeeRepository.findByEmail("ram@gmail.com");

        if(optionalEmployee.isPresent()){
            employee1 = optionalEmployee.get();
        }

        Assertions.assertThat(employee1).isNull();
    }

}
