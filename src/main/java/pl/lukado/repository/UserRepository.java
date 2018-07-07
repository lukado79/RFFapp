package pl.lukado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.lukado.entity.User;
import pl.lukado.entity.UserRole;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findAll();
	
	User deleteById(long id);
	
	User save(User entity);
	
	User findOne(long id);
	
	List<User> findByLastNameIgnoreCase(String lastName);
	
	List<User> findByFirstNameIgnoreCase(String firstName);
	
	User findFirstByEmail(String email);
	
	List<User> findByRole(UserRole role);
	
	List<User> findByEnabled(boolean enabled);
	
	
	

}
