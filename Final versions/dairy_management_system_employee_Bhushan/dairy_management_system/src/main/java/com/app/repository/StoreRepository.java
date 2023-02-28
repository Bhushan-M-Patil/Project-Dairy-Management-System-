package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
