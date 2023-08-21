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

import com.swisbank.bannkapp.entity.TransactionRequest;
import com.swisbank.bannkapp.entity.TransactionResponse;
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
	public List<Transactions>getDetailsUid(@PathVariable String uid) {
		
		return tm.getTransactionsUid(Long.valueOf(uid));
	}
	@GetMapping("/account/{aid}")
	public List<Transactions>getDetailsAid(@PathVariable String aid) {
		
		return tm.getTransactionsAid(Long.valueOf(aid));
	}
	@PostMapping("/transfer")
	public TransactionResponse transfer(@RequestBody TransactionRequest tr) {
		TransactionResponse tresp=tm.transfer(tr.getSenderAID(), tr.getReceiverAID(), tr.getAmmount());
		//return tm.getTransactionsAid(Long.valueOf(aid));
		if(tresp.isSuccess())
			tm.transactionLog(tr.getSenderAID(), tr.getReceiverAID(), tr.getMode(), tr.getAmmount(), tr.getRemarks());
	return tresp;
	}
	
}
