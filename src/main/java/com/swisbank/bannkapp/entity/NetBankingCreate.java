package com.swisbank.bannkapp.entity;

public class NetBankingCreate {
	private String password;
	private long aid;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
		this.aid = aid;
	}
	public NetBankingCreate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NetBankingCreate(String password, long aid) {
		super();
		this.password = password;
		this.aid = aid;
	}
	
}
