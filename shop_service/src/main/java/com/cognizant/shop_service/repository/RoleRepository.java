package com.cognizant.shop_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.shop_service.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	public Role findByName(String name);
	
}
