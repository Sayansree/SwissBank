package com.swisbank.bannkapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swisbank.bannkapp.entity.UserStatus;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.repository.UserRepo;

@Service
public class UserManager {
	@Autowired
	private UserRepo userData;
	
	public List<User> findAll(){
		return userData.findAll();
	}
	public boolean emailExists(String email) {
		 List<User> rows=userData.findByEmail(email);
		 return rows.size()==1;
	}

	public boolean removeUser(Long uid) {
		userData.deleteById(uid);;
		return !userData.existsById(uid);
		
	}
	
	public UserStatus addUser(User u) {
		if(emailExists(u.getEmail())) {
			return new UserStatus(false,1);
		}
		User res = userData.save(u);
		if( res.equals(u))
			return new UserStatus(true,0);
		else
			return new UserStatus(false,2);
		
	}
	
	public Optional<User> getDetails(Long uid) {
//		System.out.println(" "+uid);
		//return new User();
//		try {
		return userData.findById(uid);
//		//ur.setPasswordHash(null);
//	//	return ur;
//		}catch(Exception e) {
//			//System.out.println(e.getMessage());
//		}
//		return 
		
	}
	public User getUserById(long uid) {
		Optional<User> u=userData.findById(uid);
		if(u.isEmpty())return null;
		return u.get();
	}
	
	
}
