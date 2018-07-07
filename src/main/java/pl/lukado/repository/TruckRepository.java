package pl.lukado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.lukado.entity.Truck;

@Transactional
public interface TruckRepository extends JpaRepository<Truck, Long> {

	List<Truck> findAll();
	
	Truck findOne(long id);
	
	Truck deleteById(long id);
	
	Truck save(Truck entity);
	
	
		
}
