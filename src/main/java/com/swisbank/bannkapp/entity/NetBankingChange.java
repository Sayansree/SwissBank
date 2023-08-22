package com.swisbank.bannkapp.entity;

public class NetBankingChange {
	private String old_pass;
	private String new_pass;
	private long aid;
	public String getOld_pass() {
		return old_pass;
	}
	public void setOld_pass(String old_pass) {
		this.old_pass = old_pass;
	}
	public String getNew_pass() {
		return new_pass;
	}
	public void setNew_pass(String new_pass) {
		this.new_pass = new_pass;
	}
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
		this.aid = aid;
	}
	public NetBankingChange(String old_pass, String new_pass, long aid) {
		super();
		this.old_pass = old_pass;
		this.new_pass = new_pass;
		this.aid = aid;
	}
	public NetBankingChange() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
