package pl.lukado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukado.entity.Truck;

public interface TruckRepository extends JpaRepository<Truck, Long> {

}
