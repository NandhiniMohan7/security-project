package SecurityDemo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SecurityDemo.Entity.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {

    @Query("select p from RoleEntity p where p.roleName =?1")
	Optional<RoleEntity> findByRoleName(String name);

}
