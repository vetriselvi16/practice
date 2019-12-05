package com.cognizant.authenticationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	User findByUserId(String userId);
	List<User> findAllByStatus(String status);
	
	User findByContactNumber(Long number);
	User findByStatus(String string);
}
