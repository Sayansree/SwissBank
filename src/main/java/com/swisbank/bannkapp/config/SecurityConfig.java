package com.swisbank.bannkapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.swisbank.bannkapp.entity.Roles;

@Configuration
public class SecurityConfig {
	 @Autowired
	    private JwtAuthenticationEntryPoint point;
	    @Autowired
	    private JwtAuthenticationFilter filter;

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http.csrf(csrf -> csrf.disable())
	                .authorizeHttpRequests(atz->atz
	                	.requestMatchers("user/testAuth").authenticated()
		                .requestMatchers("user/testUser").hasRole(Roles.USER.name())
		                .requestMatchers("/user/test").permitAll()
		                .requestMatchers("/user/testAdmin").hasRole(Roles.ADMIN.name())
		                .anyRequest().permitAll()
	                )
	                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
}
