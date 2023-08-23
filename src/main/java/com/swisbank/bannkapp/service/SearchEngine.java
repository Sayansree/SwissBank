package com.swisbank.bannkapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swisbank.bannkapp.entity.AccountDetails;
import com.swisbank.bannkapp.entity.User;
import com.swisbank.bannkapp.repository.AccDetailsRepo;
import com.swisbank.bannkapp.repository.UserRepo;

@Service
public class SearchEngine {
	@Autowired
	UserRepo UserData;
	@Autowired
	AccDetailsRepo AccntDetData;
	
	public List<User> searchUserByName(String name){
		return UserData.findByNameContainingIgnoreCase(name);
	}
	public List<User> searchUserByEmail(String email){
		return UserData.findByEmailContainingIgnoreCase(email);	
	}
	public List<User> searchUserByPhone(long phone){
		return UserData.findByPhone(phone);
	}
	
	public List<AccountDetails>searchAccountByName(String name){
		String []n=name.split(" ");
		if(n.length==1)
			return AccntDetData.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name,name);
		else if(n.length==2)
			return AccntDetData.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(n[0],n[1]);
		else
			return AccntDetData.findByFirstNameContainingIgnoreCaseOrMiddleNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(n[0],n[1],n[2]);
	}
	public List<AccountDetails>searchAccountByCity(String city){
		return AccntDetData.findByAddrResContainingIgnoreCaseOrAddrPerContainingIgnoreCase(city, city);
	}
	public List<AccountDetails>searchAccountByPhone(long phone){
		return AccntDetData.findByMobile(phone);
	}
	public List<AccountDetails>searchAccountByAdhar(long adhar){
		return AccntDetData.findByAdharCard(adhar);
	}

}
