package com.swisbank.bannkapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swisbank.bannkapp.entity.AuthStatus;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.repository.UserRepo;

@Service
public class AuthManager {
	@Autowired
	private UserRepo userData;
	@Autowired
	private JwtService jwts;
	public AuthStatus matchPassword(String email,String pass) {
		 List<User> rows=userData.findByEmail(email);
		 if(rows.size()==0)return new AuthStatus(false,1,0L);
		 User u=rows.get(0);
		 if(u.getPasswordHash().equals(pass)) {
			 String token=jwts.generateToken(u);
			 AuthStatus as= new AuthStatus(true,0,(long)u.getUserID());
			 as.setAccessToken(token);
			 return as;
		 }else
			 return new AuthStatus(false,2,0L);
	}
//	public boolean phoneExists(Long num) {
//		return true;
//	}
	public boolean removeUser(Long uid) {
		userData.deleteById(uid);
		return !userData.existsById(uid);
		
	}
	
}
