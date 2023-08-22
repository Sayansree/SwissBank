package com.swisbank.bannkapp.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.entity.TransactionResponse;
import com.swisbank.bannkapp.entity.Transactions;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.repository.AccountsRepo;
import com.swisbank.bannkapp.repository.TransactionsRepo;
import com.swisbank.bannkapp.repository.UserRepo;



@Service
public class TransManager {
	@Autowired
	private TransactionsRepo transTable;
	
	@Autowired
	private AccountManager am;
//	
//	@Autowired
//	private UserManager um;
	
	public List<Transactions>getTransactionsUid(long uid){
		List<Accounts> la= am.getAccountsOfUser(uid);
		if (la==null)return null;
		return getTransactions(la);
	}
	public List<Transactions>getTransactionsAid(long aid){
		Accounts a= am.getAccountById(aid);
		if (a==null)return null;
		return getTransactions(a);
	}
	public List<Transactions> getTransactions(List<Accounts> accl){
		System.out.println(accl.size());
		List<Transactions>  ll= transTable.findAllBySenderInOrReceiverIn(accl, accl);
		System.out.println(ll.size());
		return ll;
	}
	public List<Transactions> getTransactions(Accounts acc){
		List<Transactions>  ll= transTable.findAllBySenderOrReceiver(acc, acc);
		System.out.println(ll.size());
		return ll;
	}
	
	public TransactionResponse transfer(long aid1,long aid2,double amt){
		if(amt<=0)return new TransactionResponse(6);
		if(am.getAccountById(aid1)==null) return new TransactionResponse(1);
		if(am.getAccountById(aid2)==null) return new TransactionResponse(2);
		if (!am.isActive(aid1))return  new TransactionResponse(3);
		if(!am.isActive(aid2))return  new TransactionResponse(4);
		if(!am.debit(aid1,amt))return  new TransactionResponse(5);
		if(am.credit(aid2,amt))return  new TransactionResponse(0);
		return  new TransactionResponse(7);
	}
	public boolean transactionLog(long aid1,long aid2,String mode,double amt,String rem) {
		Transactions t=new Transactions();
		//t.setTimestamp(Timestamp.from(Instant.now()));
		t.setMedium(mode);
		t.setRemarks(rem);
		t.setAmmount(amt);
		t.setSender(am.getAccountById(aid1));
		t.setReceiver(am.getAccountById(aid2));
		transTable.save(t);
		return true;
		
	}
	
	
}
