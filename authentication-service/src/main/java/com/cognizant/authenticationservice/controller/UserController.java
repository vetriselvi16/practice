package com.cognizant.authenticationservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.RoleRepository;
import com.cognizant.authenticationservice.repository.UserRepository;
import com.cognizant.authenticationservice.security.AppUserDetailsService;



@RequestMapping("/user")
@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@PostMapping("")
	public String signup(@RequestBody User user) throws UserAlreadyExistsException {
		LOGGER.debug("User={}",user);
		return appUserDetailsService.signup(user);

	}
	/*@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") String id)
	{
		userRepository.deleteById(id);
		return "true";
	}*/
	
	/*@GetMapping("/super")
	public List<User> getPendingRequest()
	{
		return userRepository.findAllByStatus("P");
	}
	@PutMapping("/super")
	public String RespondingPendingRequest(@RequestBody User user)
	{
		User modified_user = userRepository.findByUserId(user.getUserId());
		
		modified_user.setStatus(user.getStatus());
		modified_user = userRepository.save(modified_user);
		return modified_user.getStatus();
	}*/

}
