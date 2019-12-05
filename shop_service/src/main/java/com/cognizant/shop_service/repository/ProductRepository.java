package com.cognizant.shop_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.shop_service.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	@Query("From Product p where p.stockCount>0")
	List<Product> getProductListCustomer();
	
	
	Product getProductByCode(String code);
	// int getStockCountByCode(String code);

}
