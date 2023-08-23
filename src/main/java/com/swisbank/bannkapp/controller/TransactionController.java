package com.swisbank.bannkapp.controller;

import java.util.ArrayList;
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

import com.swisbank.bannkapp.entity.TransObjResp;
import com.swisbank.bannkapp.entity.TransactionRequest;
import com.swisbank.bannkapp.entity.TransactionResponse;
import com.swisbank.bannkapp.entity.Transactions;
import com.swisbank.bannkapp.service.NetBankingManager;
import com.swisbank.bannkapp.service.TransManager;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransManager tm;
	@Autowired
	private NetBankingManager nbm;
	@GetMapping("/user/{uid}")
	public List<TransObjResp>getDetailsUid(@PathVariable String uid) {
		long UID=Long.valueOf(uid);
		List<Transactions> tx= tm.getTransactionsUid(UID);
		List<TransObjResp> tres=new ArrayList<TransObjResp>();
		for(Transactions t:tx) {
			String mode;
			if(t.getReceiver().getAccountID()==-1)
				mode="WITHDRAWAL";
			else if(t.getSender().getAccountID()==-1)
				mode="DEPOSIT";
			else if(t.getSender().getOwner().getUserID()!=UID)
				mode="CREDIT";
			else if(t.getReceiver().getOwner().getUserID()!=UID)
				mode="DEBIT";
			else
				mode="SELF";
			TransObjResp obj=new TransObjResp(t,mode);
			tres.add(obj);
		}
		return tres;
	}
	@GetMapping("/account/{aid}")
	public List<TransObjResp>getDetailsAid(@PathVariable String aid) {
		
		long AID=Long.valueOf(aid);
		List<Transactions> tx= tm.getTransactionsAid(AID);
		List<TransObjResp> tres=new ArrayList<TransObjResp>();
		for(Transactions t:tx) {
			String mode;
			if(t.getReceiver().getAccountID()==-1)
				mode="WITHDRAWAL";
			else if(t.getSender().getAccountID()==-1)
				mode="DEPOSIT";
			else if(t.getSender().getAccountID()!=AID)
				mode="CREDIT";
			else if(t.getReceiver().getAccountID()!=AID)
				mode="DEBIT";
			else
				mode="SELF";
			TransObjResp obj=new TransObjResp(t,mode);
			tres.add(obj);
		}
		return tres;
	}
	@PostMapping("/transfer")
	public TransactionResponse transfer(@RequestBody TransactionRequest tr) {
		if(!nbm.isPresent(tr.getSenderAID()))
			return new TransactionResponse(8);
		if(!nbm.getPass(tr.getSenderAID()).equals(tr.getPassword()))
			return new TransactionResponse(9);
		TransactionResponse tresp=tm.transfer(tr.getSenderAID(), tr.getReceiverAID(), tr.getAmmount());
		//return tm.getTransactionsAid(Long.valueOf(aid));
		if(tresp.isSuccess())
			tm.transactionLog(tr.getSenderAID(), tr.getReceiverAID(), tr.getMode(), tr.getAmmount(), tr.getRemarks());
	return tresp;
	}
	@PostMapping("/withdraw")//admin
	public TransactionResponse withdraw(@RequestBody TransactionRequest tr) {
		TransactionResponse tresp=tm.withdraw(tr.getSenderAID(), tr.getAmmount());
		//return tm.getTransactionsAid(Long.valueOf(aid));
		if(tresp.isSuccess())
			tm.transactionLog(tr.getSenderAID(), -1, "IMPS", tr.getAmmount(), tr.getRemarks());
	return tresp;
	}
	@PostMapping("/deposit")//admin
	public TransactionResponse deposit(@RequestBody TransactionRequest tr) {
		
		TransactionResponse tresp=tm.deposit( tr.getReceiverAID(), tr.getAmmount());
		//return tm.getTransactionsAid(Long.valueOf(aid));
		if(tresp.isSuccess())
			tm.transactionLog(-1, tr.getReceiverAID(),"IMPS", tr.getAmmount(), tr.getRemarks());
	return tresp;
	}
	
}
