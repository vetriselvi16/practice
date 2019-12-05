package com.cognizant.authenticationservice.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	@Autowired
    UserRepository userRepository;

	
	
	@GetMapping("/authentication")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Start of auth function");
		HashMap<String, String> map = new HashMap<String, String>();
		User user=userRepository.findByUserId(getUser(authHeader));
		/*LOGGER.debug("User:{}",user);
		if(user==null){
			System.out.println("NO USER");
		}*/
		
        if(user.getStatus().equalsIgnoreCase("A"))
        {
        	String JWT = generateJwt((getUser(authHeader)));
        	String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
        	LOGGER.debug("JWT:{}",JWT);
        	map.put("token",JWT );
        	map.put("role", role);
    		System.out.println(map);
    		LOGGER.info("END OF AUTH FUNCTION");
        }
        else
        {
        	map.put("token", null);
        	if(user.getStatus().equalsIgnoreCase("P"))
        	{
                map.put("status","P");
        	}
        	else if(user.getStatus().equalsIgnoreCase("D"))
        	{
                map.put("status", "D");
        	}
		}
        return map;
		
		
		/*map.put("token", "");
		String JWT = generateJwt((getUser(authHeader)));
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		LOGGER.debug("JWT:{}",JWT);
		map.put("token",JWT );
		map.put("role", role);

		System.out.println(map);
		LOGGER.info("END OF AUTH FUNCTION");
		return map;*/
	}


	private String getUser(String authHeader) {
		String encodedCredentials = authHeader.split(" ", 2)[1];
		String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
		String user = decoded.substring(0, decoded.indexOf(':'));
		return user;
	}
	
	/*private String getPassword(String authHeader) {
		String encodedCredentials = authHeader.split(" ", 2)[1];
		String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
		String pwd = decoded.substring(decoded.indexOf(':') + 1);
		return pwd;
	}*/

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date());

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();

		return token;
	}

}
