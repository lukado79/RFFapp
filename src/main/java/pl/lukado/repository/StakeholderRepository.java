package pl.lukado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.lukado.entity.StakRole;
import pl.lukado.entity.Stakeholder;

@Transactional
public interface StakeholderRepository extends JpaRepository<Stakeholder, Long> {

	List<Stakeholder> findAll();

	Stakeholder findOne(long id);

	Stakeholder deleteById(long id);

	Stakeholder save(Stakeholder entity);

	List<Stakeholder> findByName(String name); 

	List<Stakeholder> findByCountry(String country);

	List<Stakeholder> findByCity(String city);

	List<Stakeholder> findByPost(String post);

	List<Stakeholder> findByStakeRole(StakRole stakeRole);
	
	List<Stakeholder> findByEmail(String mail);

}
