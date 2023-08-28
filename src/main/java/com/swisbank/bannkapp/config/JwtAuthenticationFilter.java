package com.swisbank.bannkapp.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.service.JwtService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserDetailsService udc;
	
	@Override
	protected void doFilterInternal(
			@NonNull HttpServletRequest request, 
			@NonNull HttpServletResponse response, 
			@NonNull FilterChain filterChain) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authHeader=request.getHeader("Authorization");
		if(authHeader==null||!authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		final String jwt=authHeader.substring(7);
		String userID=null;//=jwtService.extractID(jwt);
		 try {

			 userID=jwtService.extractID(jwt);
         } catch (IllegalArgumentException e) {
             System.out.println("Illegal Argument while fetching the username !!");
             e.printStackTrace();
         } catch (ExpiredJwtException e) {
             System.out.println("Given jwt token is expired !!");
             e.printStackTrace();
         } catch (MalformedJwtException e) {
             System.out.println("Some changed has done in token !! Invalid Token");
             e.printStackTrace();
         } catch (Exception e) {
             e.printStackTrace();

         }

		if(userID!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
			User user=(User) this.udc.loadUserByUsername(userID);
			if(jwtService.validate(jwt, user)) {
				UsernamePasswordAuthenticationToken authToken =new UsernamePasswordAuthenticationToken(
						user,
						null,
						user.getAuthorities()
						);
				SecurityContextHolder.getContext().setAuthentication(authToken);
				authToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request) 
						);
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}else {
				System.out.println("invalid");
			}
		}
		
		filterChain.doFilter(request, response);

		
	}

}
