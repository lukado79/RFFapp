package pl.lukado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukado.entity.User;
import pl.lukado.entity.UserRole;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	
	void deleteById(long id);
	
	User save(User entity);
	
	User findOne(long id);
	
	User findFirstByEmail(String email);
	
	List<User> findByRole(UserRole role);
	

	
	
	

}
