package com.cognizant.shop_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.shop_service.model.User;
import com.cognizant.shop_service.repository.UserRepository;
import com.cognizant.shop_service.service.SuperUserService;

@RequestMapping("/super")
@RestController
public class SuperUserController {

	@Autowired
	SuperUserService userservice;
	
	@GetMapping("")
	public List<User> getPendingRequest()
	{
		return userservice.getPendingRequest();
	}
	
	@PutMapping("")
	public List<User> RespondingPendingRequest(@RequestBody User user)
	{
		return userservice.RespondingPendingRequest(user);
	}
}
