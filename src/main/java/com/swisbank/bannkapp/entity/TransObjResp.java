package com.swisbank.bannkapp.entity;

import java.sql.Timestamp;

public class TransObjResp {
	private long sender;
	private long receiver;
	private TransMed medium;
	private Timestamp timestamp;
	private double ammount;
	private long txid;

	private String remarks;
	private String category;
	public long getSender() {
		return sender;
	}
	public void setSender(long sender) {
		this.sender = sender;
	}
	public long getReceiver() {
		return receiver;
	}
	public void setReceiver(long receiver) {
		this.receiver = receiver;
	}
	public TransMed getMedium() {
		return medium;
	}
	public void setMedium(TransMed medium) {
		this.medium = medium;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public long getTxid() {
		return txid;
	}
	public void setTxid(long txid) {
		this.txid = txid;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public TransObjResp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransObjResp(long sender, long receiver, TransMed medium, Timestamp timestamp, double ammount, long txid,
			String remarks, String category) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.medium = medium;
		this.timestamp = timestamp;
		this.ammount = ammount;
		this.txid = txid;
		this.remarks = remarks;
		this.category = category;
	}
	public TransObjResp(Transactions tx, String category) {
		super();
		this.sender = tx.getSender().getAccountID();
		this.receiver = tx.getReceiver().getAccountID();
		this.medium = tx.getMedium();
		this.timestamp = tx.getTimestamp();
		this.ammount = tx.getAmmount();
		this.txid = tx.getTxid();
		this.remarks = tx.getRemarks();
		this.category = category;
	}
	
	
}
