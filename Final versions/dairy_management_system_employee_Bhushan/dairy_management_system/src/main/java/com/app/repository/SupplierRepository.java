package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Suppliers;

public interface SupplierRepository extends JpaRepository<Suppliers, Long> {

	

}


