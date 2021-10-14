import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

 
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.service.EmployeeService;
 

 
public class TestEmployeeManager {
     
    @InjectMocks
    Employee manager;
     
    @Mock
    EmployeeService dao;
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void getAllEmployeesTest()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee("poojajp@gmail.com", "Pooja", "J P");
        Employee empTwo = new Employee( "abc@gmail.com", "ABC", "A");
        Employee empThree = new Employee("xyz@gmail.com", "XYZ", "X");
         
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
         
        when(dao.getEmployeeList()).thenReturn(list);
         
        //test
        List<Employee> empList = manager.getEmployeeList();
         
        assertEquals(3, empList.size());
        verify(dao, times(1)).getEmployeeList();
    }
     
    @Test
    public void getEmployeeByIdTest()
    {
        when(dao.getEmployeeById(1)).thenReturn(new Employee("poojajp@gmail.com", "Pooja", "J P"));
         
        Employee emp = manager.getEmployeeById(1);
         
        assertEquals("Pooja", emp.getFirstName());
        assertEquals("J P", emp.getLastName());
        assertEquals("poojajp@gmail.com", emp.getEmailId());
    }
     
    @Test
    public void createEmployeeTest()
    {
        Employee emp = new Employee("poojajp@gmail.com", "Pooja", "J P");
        manager.createEmployee(emp);         
        verify(dao, times(1)).createEmployee(emp);
    }
}
