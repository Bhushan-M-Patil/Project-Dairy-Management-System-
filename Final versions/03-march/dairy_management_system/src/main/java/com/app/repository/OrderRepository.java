package com.app.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	@Modifying
	@Query("select o from Order o where o.id = :id and o.orderDate = :orderDate")
	Order findByIdAndDate(@Param("id") Long id,@Param("orderDate") LocalDate orderDate);
}
