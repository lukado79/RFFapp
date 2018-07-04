package pl.lukado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukado.entity.Stakeholder;

public interface StakeholderRepository extends JpaRepository<Stakeholder, Long> {

}
