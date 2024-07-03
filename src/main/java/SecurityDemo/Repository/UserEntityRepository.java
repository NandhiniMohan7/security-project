package SecurityDemo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SecurityDemo.Entity.UserEntity;

public interface UserEntityRepository  extends JpaRepository<UserEntity,Long> {
	Optional<UserEntity> findByUserName(String username);
	Boolean existsByUserName(String username);

}
