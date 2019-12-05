package com.cognizant.authenticationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.authenticationservice.security.AppUserDetailsService;
import com.cognizant.authenticationservice.security.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Autowired
    private AppUserDetailsService appUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(newpasswordEncoder());
	}

	@Bean
	public PasswordEncoder newpasswordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception 
	{
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/authentication").permitAll()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().antMatchers("/user").permitAll()
		.anyRequest().authenticated().and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
		
	}
	
}
