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

import com.swisbank.bannkapp.entity.AccFilter;
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
	
	@PostMapping("/filter")//admin only
	List<Accounts> getAccountFilter(@RequestBody AccFilter af){
		return am.accountsFilter(af.getStates(),af.getMinBal(),af.getMaxBal());
	}
	
	@GetMapping("/summary/{uid}")
	List <Accounts> getAccountSummary(@PathVariable String uid){
		return am.getAccountsOfUser(Long.valueOf(uid));
	}
	@GetMapping("/activate/{aid}")//admin only
	public boolean Activate(@PathVariable String aid){
		return am.Activate(Long.valueOf(aid));
	}
	@GetMapping("/suspend/{aid}")//admin only
	public boolean Suspend(@PathVariable String aid){
		return am.Suspend(Long.valueOf(aid));
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
