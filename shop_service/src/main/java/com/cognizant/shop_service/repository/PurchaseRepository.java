package com.cognizant.shop_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.shop_service.model.Purchase;


public interface PurchaseRepository extends JpaRepository<Purchase,Integer>{

}
