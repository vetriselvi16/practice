package com.cognizant.authenticationservice.security;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.model.Role;
import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.RoleRepository;
import com.cognizant.authenticationservice.repository.UserRepository;



@Service
public class AppUserDetailsService implements UserDetailsService{

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	public String signup(User signedUser)
	{
		User isMember = userRepository.findByUserId(signedUser.getUserId());
		if(isMember == null)
		{
			User user = new User();
			user.setFirstname(signedUser.getFirstname());
			user.setLastname(signedUser.getLastname());
			user.setAge(signedUser.getAge());
			user.setGender(signedUser.getGender());
			user.setContactNumber(signedUser.getContactNumber());
			user.setUserId(signedUser.getUserId());
			user.setPassword(passwordEncoder().encode(signedUser.getPassword()));
			String type = signedUser.getUserType();
			user.setUserType(type);
			user.setStatus(signedUser.getStatus());
			user.setAnswer1(signedUser.getAnswer1());
			user.setAnswer2(signedUser.getAnswer2());
			user.setAnswer3(signedUser.getAnswer3());
			Role role =null;
			if(signedUser.getUserType().equalsIgnoreCase("U"))
			{
				role = roleRepository.findByName("USER");
			}
			else if(signedUser.getUserType().equalsIgnoreCase("A"))
			{
				role = roleRepository.findByName("ADMIN");
			}
			//Role role = roleRepository.findByName("USER");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);
			return "true";

		} 
		else 
		{
			return "false";
		}
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException 
	{
		User user=userRepository.findByUserId(userId);
		AppUser appUser = null;
		if(user == null)
		{
			throw new UsernameNotFoundException("UserName not exists!");
		}
		else
		{
			appUser = new AppUser(user);
			//return appUser;
		}
		return appUser;
	}
}
