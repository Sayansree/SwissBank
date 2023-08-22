package com.swisbank.bannkapp.controller;

import java.util.List;

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
import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.entity.NetBankingChange;
import com.swisbank.bannkapp.entity.NetBankingCreate;
import com.swisbank.bannkapp.service.AccountManager;
import com.swisbank.bannkapp.service.NetBankingManager;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/net-banking")
public class NetBankingController {
//	@Autowired
//	private AccountManager am;
	
	@Autowired
	private NetBankingManager nbm;
	
//	@DeleteMapping("/delete/{aid}")
//	public boolean delNetBanking(@PathVariable String aid){
//		return nbm.delete(aid);
//	}
	@PostMapping("/change")
	 public int changePassword(@RequestBody NetBankingChange nbc){
		return nbm.updateNB(nbc.getAid(),nbc.getOld_pass(),nbc.getNew_pass());
	}
	@PostMapping("/create")
	public boolean createPassword(@RequestBody NetBankingCreate nbc){
		return nbm.createNB(nbc.getAid(),nbc.getPassword());
	}
}
