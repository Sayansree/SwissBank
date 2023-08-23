package com.swisbank.bannkapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swisbank.bannkapp.entity.AccState;
import com.swisbank.bannkapp.entity.AccountDetails;
import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.repository.AccDetailsRepo;
import com.swisbank.bannkapp.repository.AccountsRepo;
import com.swisbank.bannkapp.repository.UserRepo;

@Service
public class AccountManager {
	@Autowired
	private AccountsRepo accntTable;
	
	@Autowired
	private AccDetailsRepo accDetTable;
	
	@Autowired
	private UserManager um;
	
	public List<Accounts> accountsFilter(List<String> state,double min,double max) {
		List<AccState> st=new ArrayList<AccState>();
		for(String s:state) {
			st.add(AccState.valueOf(s));
		}
		List<Accounts> a =accntTable.findAllByStateInAndBalanceBetweenAndAccountIDNot(st,min,max,-1);
		return a;
	}
	//get account from account id
	public Accounts getAccountById(Long aid) {
		Optional<Accounts> a =accntTable.findById(aid);
		if(a.isEmpty())return null;
		else return a.get();
	}
	//get account details from account id
	public AccountDetails getAccountDetailsById(Long aid) {
		Optional<AccountDetails> a =accDetTable.findById(aid);
		if(a.isEmpty())return null;
		else return a.get();
	}
	//get accounts associated with a uid
	public List<Accounts> getAccountsOfUser(Long uid){
		User u=um.getUserById(uid);
		if(u==null)return null;
		System.out.println(u.getAccnts().size());
		return u.getAccnts();
	}
	public boolean isPresent(long aid) {
		return getAccountById(aid)!=null;
	}
	//get account details from account id
	public boolean debit(Long aid,double amt) {
		Accounts a=getAccountById(aid);
		if(a==null)return false;
		if(a.getBalance()<amt)return false;
		// update
		double new_bal=a.getBalance()-amt;
		a.setBalance(new_bal);
		a=accntTable.save(a);
		return a.getBalance()==new_bal;
	}
	public boolean credit(Long aid,double amt) {
		Accounts a=getAccountById(aid);
		if(a==null)return false;
		double new_bal=a.getBalance()+amt;
		a.setBalance(new_bal);
		a=accntTable.save(a);
		return a.getBalance()==new_bal;
	}
	public boolean isActive(Long aid) {
		Optional<Accounts> a =accntTable.findById(aid);
		if(a.isEmpty())return false;
		return a.get().getState()==AccState.ACTIVE;
	}
	public boolean Activate(Long aid) {
		Optional<Accounts> a =accntTable.findById(aid);
		if(a.isEmpty())return false;
		a.get().setState(AccState.ACTIVE);
		Accounts b=accntTable.save(a.get());
		return b.getState()==AccState.ACTIVE;
	}
	public boolean Suspend(Long aid) {
		Optional<Accounts> a =accntTable.findById(aid);
		if(a.isEmpty())return false;
		a.get().setState(AccState.SUSPENDED);
		Accounts b=accntTable.save(a.get());
		return b.getState()==AccState.SUSPENDED;
	}
	
	//create account 
	public boolean createAccount(Long uid,AccountDetails ad){
		User u=um.getUserById(uid);
		if(u==null)return false;//uid not found
		Accounts newacc=new Accounts();
		newacc.setOwner(u);
		newacc.setBalance(0);
		newacc.setState(AccState.PROCESSING);
		newacc=accntTable.save(newacc);
		
		newacc.setDetails(ad);
		ad.setAccount(newacc);
		//ad.setAccid(newacc.getAccountID());
		accDetTable.save(ad);
		return true;
	}
	
}
