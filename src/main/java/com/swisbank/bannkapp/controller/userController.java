package com.swisbank.bannkapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swisbank.bannkapp.entity.AuthReq;
import com.swisbank.bannkapp.entity.AuthStatus;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.entity.UserStatus;
import com.swisbank.bannkapp.repository.UserRepo ;
import com.swisbank.bannkapp.service.AuthManager;
import com.swisbank.bannkapp.service.UserManager;
//import ja
@CrossOrigin
@Controller
@RestController
@RequestMapping("/user")
public class userController {
	
	
	@Autowired
	UserManager um;
	@Autowired
	AuthManager am;
	
	@GetMapping("/getAll")//admin only
	 List<User> getUser() {
		return um.findAll();
	}
	@GetMapping("/test")
	String test() {
		return "Hello world!";
	}
	@PostMapping("/register")//working, no auth
	UserStatus register(@RequestBody User newUser) {
		 return um.addUser(newUser);
	}
	
	@GetMapping("/info/{uid}")//working,admin,user auth
	User getDetails(@PathVariable String uid) {
		
		Optional<User> uu= um.getDetails(Long.valueOf(uid));
		if(uu.isEmpty())return null;
		uu.get().setPasswordHash("");
		return uu.get();
	}
	@DeleteMapping("/delete/{uid}")//working, check for admin,user auth
	boolean delete(@PathVariable String uid) {		
		return um.removeUser(Long.valueOf(uid));
	}
	
	@PostMapping("/auth") //working
	AuthStatus login(@RequestBody AuthReq authobj) {
		return am.matchPassword(authobj.getEmail(), authobj.getPasswordHash());
	}
	
}
