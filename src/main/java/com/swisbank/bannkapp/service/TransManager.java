package com.swisbank.bannkapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swisbank.bannkapp.entity.Accounts;
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
	private AccountsRepo accntTable;
	
	@Autowired
	private UserRepo usrTable;
	
	public List<Accounts>getAccounts(long uid){
		Optional<User> u=usrTable.findById(uid);
		if(u.isEmpty())return null;
		System.out.println(u.toString());
		return accntTable.findAllByOwner(u.get());
	}
	public List<Transactions> getTransactions(List<Accounts> accl){
		System.out.println(accl.size());
		List<Transactions>  ll= transTable.findAllBySenderInOrReceiverIn(accl, accl);
		System.out.println(ll.size());
		return ll;
	}
}
