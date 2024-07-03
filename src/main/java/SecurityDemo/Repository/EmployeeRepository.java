package SecurityDemo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SecurityDemo.Entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,Long>{
	Optional<Employee> findByEmpName(String name);

}
