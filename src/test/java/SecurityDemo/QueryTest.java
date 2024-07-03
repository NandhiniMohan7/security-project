package SecurityDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import SecurityDemo.Entity.RoleEntity;
import SecurityDemo.Repository.RoleEntityRepository;

@SpringBootTest
public class QueryTest {
	
	@Autowired
	private RoleEntityRepository roleEntityRepository;
	
	@Test
	public void getByRoleName() {
		RoleEntity role = roleEntityRepository.findByRoleName("USER").orElse(null);
		if (role != null) {
			System.out.println(role.getId());
		} else {
			System.out.println("Role not found");
		}
	}

}
