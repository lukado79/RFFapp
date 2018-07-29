package pl.lukado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lukado.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findAll();

	Order save(Order entity);

	void deleteById(long id);

	Order findOne(long id);


}
