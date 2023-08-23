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

import com.swisbank.bannkapp.entity.AccountDetails;
import com.swisbank.bannkapp.entity.AuthReq;
import com.swisbank.bannkapp.entity.AuthStatus;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.entity.UserStatus;
import com.swisbank.bannkapp.service.AuthManager;
import com.swisbank.bannkapp.service.SearchEngine;
import com.swisbank.bannkapp.service.UserManager;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/search")
public class SearchController {
	@Autowired
	SearchEngine se;
	
	
	@GetMapping("/user/name/{name}")//admin only
	 List<User> getUserByName(@PathVariable String name) {
		return se.searchUserByName(name);
	}
	@GetMapping("/user/email/{email}")//admin only
	 List<User> getUserByEmail(@PathVariable String email) {
		return se.searchUserByEmail(email);
	}
	@GetMapping("/user/phone/{phone}")//admin only
	 List<User> getUserByPhone(@PathVariable String phone) {
		return se.searchUserByPhone(Long.valueOf(phone));
	}
//accounts
	@GetMapping("/account/name/{name}")//admin only
	 List<AccountDetails> getAccountByName(@PathVariable String name) {
	
		return se.searchAccountByName(name);
	}
	@GetMapping("/account/city/{city}")//admin only
	 List<AccountDetails> getAccountByCity(@PathVariable String city) {
		return se.searchAccountByCity(city);
	}
	@GetMapping("/account/phone/{phone}")//admin only
	 List<AccountDetails> getAccountByPhone(@PathVariable String phone) {
		return se.searchAccountByPhone(Long.valueOf(phone));
	}
	@GetMapping("/account/adhar/{adhar}")//admin only
	 List<AccountDetails> getAccountByAdhar(@PathVariable String adhar) {
		return se.searchAccountByAdhar(Long.valueOf(adhar));
	}
	
	
//	@PostMapping("/auth") //working
//	AuthStatus login(@RequestBody AuthReq authobj) {
//		return am.matchPassword(authobj.getEmail(), authobj.getPasswordHash());
//	}
}
