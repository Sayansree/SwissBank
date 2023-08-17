package com.swisbank.bannkapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swisbank.bannkapp.entity.Transactions;
import com.swisbank.bannkapp.service.TransManager;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransManager tm;
	
	@GetMapping("/user/{uid}")
	public List<Transactions>getDetails(@PathVariable String uid) {
		
		return tm.getTransactions(tm.getAccounts(Long.valueOf(uid)));
	}
}
