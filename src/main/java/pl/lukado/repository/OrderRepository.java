package pl.lukado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukado.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
