package com.swisbank.bannkapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.swisbank.bannkapp.service.UserManager;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

	
	@Autowired
	private  UserManager um;
	@Bean
	public UserDetailsService userDetailsService() {
		return userId -> um.getUserById(Long.valueOf(userId));
	}
//	public ApplicationConfig(UserManager um) {
//		super();
//		this.um = um;
//	}
	
}
