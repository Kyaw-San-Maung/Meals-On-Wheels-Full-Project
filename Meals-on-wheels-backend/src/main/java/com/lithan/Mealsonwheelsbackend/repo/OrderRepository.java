package com.lithan.Mealsonwheelsbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.Mealsonwheelsbackend.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByRiderId(Long riderId);

}
