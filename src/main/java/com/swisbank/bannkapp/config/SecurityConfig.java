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
	                	.requestMatchers("/user/testAuth").authenticated()
		                .requestMatchers("/user/testUser").hasAnyAuthority(Roles.USER.name())
		                .requestMatchers("/user/test").permitAll()
		                .requestMatchers("/user/testAdmin").hasAnyAuthority(Roles.ADMIN.name())
		                .requestMatchers("/user/testBoth").hasAnyAuthority(Roles.ADMIN.name(),Roles.USER.name())
		                
		                //user
		                .requestMatchers("/user/register").hasAnyAuthority(Roles.USER.name())
		                .requestMatchers("/user/auth").permitAll()
		                .requestMatchers("/user/getAll").hasAnyAuthority(Roles.ADMIN.name())
		                .requestMatchers("/user/info/**").hasAnyAuthority(Roles.ADMIN.name(),Roles.USER.name())
		                
		                //account
		                .requestMatchers("/account/create/**").hasAnyAuthority(Roles.USER.name())
		                .requestMatchers("/account/summary/**").authenticated()
		                .requestMatchers("/account/details/**").authenticated()
		                .requestMatchers("/account/activate/**").hasAnyAuthority(Roles.ADMIN.name())
		                .requestMatchers("/account/suspend/**").hasAnyAuthority(Roles.ADMIN.name())
		                .requestMatchers("/account/filter").hasAnyAuthority(Roles.ADMIN.name())
		                
		                //transactions
		                .requestMatchers("/transactions/transfer").hasAnyAuthority(Roles.USER.name())
		                .requestMatchers("/transactions/withdraw").hasAnyAuthority(Roles.USER.name())
		                .requestMatchers("/transactions/deposit").hasAnyAuthority(Roles.USER.name())
		                .requestMatchers("/transactions/account/**").authenticated()
		                .requestMatchers("/transactions/user/**").authenticated()
		                .requestMatchers("/transactions/all").hasAnyAuthority(Roles.ADMIN.name())
		                
		                //net-banking
		                .requestMatchers("/net-banking/**").authenticated()
		                //search
		                .requestMatchers("/search/**").hasAnyAuthority(Roles.ADMIN.name())
		                
		                .anyRequest().denyAll()
	                )
	                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
}
