package pl.lukado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.lukado.entity.OrderStatus;


public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
	
	List<OrderStatus> findAll();
	
	OrderStatus findOne(long id);
	
	OrderStatus save(OrderStatus entity);
	
	OrderStatus deleteById(long id);

}
