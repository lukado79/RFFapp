package pl.lukado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukado.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
