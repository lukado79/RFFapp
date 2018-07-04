package pl.lukado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukado.entity.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

}
