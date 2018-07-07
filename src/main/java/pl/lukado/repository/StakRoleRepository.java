package pl.lukado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.lukado.entity.StakRole;
@Transactional
public interface StakRoleRepository extends JpaRepository<StakRole, Long> {

	List<StakRole> findaAll();
	
	void deleteById(long id);
	
	StakRole save(StakRole entity);
	
	StakRole findOne(long id);
}
