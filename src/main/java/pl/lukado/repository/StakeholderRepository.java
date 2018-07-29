package pl.lukado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukado.entity.Stakeholder;


public interface StakeholderRepository extends JpaRepository<Stakeholder, Long> {

	List<Stakeholder> findAll();

	Stakeholder findOne(long id);

	void deleteById(long id);

	Stakeholder save(Stakeholder entity);


	List<Stakeholder> findByStakeRoleLike(String stakeRole);
	

	

}
