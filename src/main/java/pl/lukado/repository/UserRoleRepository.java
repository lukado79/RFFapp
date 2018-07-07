package pl.lukado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.lukado.entity.UserRole;

@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	
	List<UserRole> findAll();
	
	void deleteById(long id);
	
	UserRole save(UserRole entity);
	
	UserRole findOne(long id);
	
	

}
