package com.cognizant.shop_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.shop_service.model.User;
import com.cognizant.shop_service.repository.UserRepository;

@Service
public class SuperUserService {

	@Autowired
	UserRepository userRepository;
	

	public List<User> getPendingRequest()
	{
		return userRepository.findAllByStatus("P");
	}
	
	
	public List<User> RespondingPendingRequest(User user)
	{
		User modified_user = userRepository.findByUserId(user.getUserId());
		
		modified_user.setStatus(user.getStatus());
		modified_user = userRepository.save(modified_user);
		return userRepository.findAllByStatus("P");
	}
}
