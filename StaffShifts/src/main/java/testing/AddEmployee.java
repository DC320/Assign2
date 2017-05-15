package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import employeeshifts.Employee;
import employeeshifts.EmployeeRepository;
import employeeshifts.Manager;


public class AddEmployee {

	
	private EmployeeRepository employees;
	Manager david = new Manager("David", "password","ROLE_MANAGER");
	
	@Test
	public void existingElNameTest() {
		employees.deleteAll();
		assertTrue(employees.count()==0);
		employees.save(new Employee("John", "Smith", "Bar Staff", david));
		assertTrue(employees.count()==1);
	}

	

}
