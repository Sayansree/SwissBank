package com.swisbank.bannkapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swisbank.bannkapp.entity.AccountDetails;
import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.service.AccountManager;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountManager am;
	
	@GetMapping("/summary/{uid}")
	List <Accounts> getAccountSummary(@PathVariable String uid){
		return am.getAccountsOfUser(Long.valueOf(uid));
	}
	@GetMapping("/details/{aid}")
	 AccountDetails getAccountDetails(@PathVariable String aid){
		return am.getAccountDetailsById(Long.valueOf(aid));
	}
	@PostMapping("/create/{uid}")
	void getAccountSummary(@PathVariable String uid,@RequestBody AccountDetails ad){
		am.createAccount(Long.valueOf(uid), ad);
	}
	
	
}
