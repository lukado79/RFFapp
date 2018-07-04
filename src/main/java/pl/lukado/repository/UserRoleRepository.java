package pl.lukado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukado.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
