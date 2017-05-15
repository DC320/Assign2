
package employeeshifts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository employees;
	private final ManagerRepository managers;

	@Autowired
	public DatabaseLoader(EmployeeRepository employeeRepository,
						  ManagerRepository managerRepository) {

		this.employees = employeeRepository;
		this.managers = managerRepository;
	}

	@Override
	public void run(String... strings) throws Exception {

		Manager david = this.managers.save(new Manager("David", "password",
							"ROLE_MANAGER"));


		SecurityContextHolder.getContext().setAuthentication(
			new UsernamePasswordAuthenticationToken("David", "doesn't matter",
				AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

		this.employees.save(new Employee("John", "Smith", "Bar Staff", david));
		this.employees.save(new Employee("Liz", "Thomas", "Bar Staff", david));
		this.employees.save(new Employee("Sam", "Evans", "Bar Staff", david));
		this.employees.save(new Employee("Eric", "Williams", "Bar Staff", david));
		this.employees.save(new Employee("Paul", "Taylor", "Waiting Staff", david));
		this.employees.save(new Employee("Anne", "Robins", "Waiting Staff", david));
		this.employees.save(new Employee("Steve", "Wright", "Waiting Staff", david));
		this.employees.save(new Employee("Mary", "Wood", "Waiting Staff", david));
		this.employees.save(new Employee("Ellen", "Hill", "Waiting Staff", david));
		this.employees.save(new Employee("Josh", "Clark", "Chef", david));
		this.employees.save(new Employee("Tim", "King", "Chef", david));
		this.employees.save(new Employee("Jeff", "Baker", "Chef", david));

		SecurityContextHolder.clearContext();
	}
}
