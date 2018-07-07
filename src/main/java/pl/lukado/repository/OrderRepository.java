package pl.lukado.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pl.lukado.entity.Order;
import pl.lukado.entity.OrderStatus;
import pl.lukado.entity.Stakeholder;
import pl.lukado.entity.Truck;
import pl.lukado.entity.User;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAll();

	Order save(Order entity);

	Order deleteById(long id);

	Order findOne(long id);

	List<Order> findByClient(Stakeholder client);

	List<Order> findByCarier(Stakeholder carier);

	List<Order> findByTruck(Truck truck);

	List<Order> findByUser(User user);

	List<Order> findByLoadComp(String loadComp);

	List<Order> findByUnloadComp(String unloadComp);

	List<Order> findByLoadCountry(String loadCountry);

	List<Order> findByUnloadCountry(String unloadCountry);

	List<Order> findByLoadCity(String loadCity);

	List<Order> findByUnloadCity(String unloadCity);

	List<Order> findByStatus(OrderStatus status);

	@Query("SELECT a FROM Order a WHERE a.loadDate BETWEEN :firstLoadDate AND :secondLoadDate")
	List<Order> findAllWhereLoadDateBetweenDates(@Param("firstLoadDate") Date firstLoadDate,
			@Param("secondLoadDate") Date secondLoadDate);

	@Query("SELECT a FROM Order a WHERE a.unloadDate BETWEEN :firstUnloadDate AND :secondUnloadDate")
	List<Order> findAllWhereUnloadDateBetweenDates(@Param("firstUnloadDate") Date firstUnloadDate,
			@Param("secondUnloadDate") Date secondUnloadDate);

	@Query("SELECT a FROM Order a WHERE a.loadDate IS :loadDate AND a.unloadDate IS :unloadDate")
	List<Order> findAllWhereLoadDateAndUnloadDate(@Param("loadDate") Date loadDate,
			@Param("unloadDate") Date unloadDate);

}
