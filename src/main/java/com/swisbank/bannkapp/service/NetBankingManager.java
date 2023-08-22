package com.swisbank.bannkapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swisbank.bannkapp.entity.Accounts;
import com.swisbank.bannkapp.entity.NetBanking;
import com.swisbank.bannkapp.repository.NetBankRepo;

@Service
public class NetBankingManager {
	@Autowired
	private NetBankRepo nbr;
	
	@Autowired
	private AccountManager am;
	
	public NetBanking getNetBanking(long aid) {
		Optional<NetBanking> nb=nbr.findById(aid);
		if(nb.isEmpty())return null;
		return nb.get();
	}
	
	public boolean isPresent(long aid) {
		return getNetBanking(aid)!=null;
	}
	public String getPass(long aid) {
		NetBanking nb=getNetBanking(aid);
		if(nb==null)return null;
		return nb.getPassword();
	}
	
	public boolean createNB(long aid,String password) {
		Accounts a=am.getAccountById(aid);
		if(a==null)return false;
		if(getNetBanking(aid)!=null)return false;
		NetBanking nb=new NetBanking();
		nb.setPassword(password);
		a.setNetbanking(nb);
		nb.setAccount(a);
		nbr.save(nb);
		return true;
	}
	public int updateNB(long aid,String old_pass,String new_pass) {
		if(!am.isPresent(aid))return 1;//no account
		NetBanking nb=getNetBanking(aid);
		if(nb==null)return 2;//no net banking 
		if(old_pass==new_pass)return 3;//same password
		if(!old_pass.equals(getPass(aid)))return 4;//mismatch
		
		nb.setPassword(new_pass);
		nbr.save(nb);
		return 0;
	}
	
	
	
}
