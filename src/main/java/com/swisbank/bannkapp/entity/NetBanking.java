package com.swisbank.bannkapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class NetBanking {
	@Id
	@Column(name="accountid",nullable=false,unique=true)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long accid;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name="accid")
	@JsonIgnore
	private Accounts account;
	
	@Column(name="password",length=255,nullable=false,unique=false)
	private String password;

	public long getAccid() {
		return accid;
	}

	public void setAccid(long accid) {
		this.accid = accid;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public NetBanking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NetBanking(long accid, Accounts account, String password) {
		super();
		this.accid = accid;
		this.account = account;
		this.password = password;
	}
	
	
}
