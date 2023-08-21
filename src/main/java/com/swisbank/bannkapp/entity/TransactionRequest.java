package com.swisbank.bannkapp.entity;

public class TransactionRequest {
	long senderAID;
	long receiverAID;
	double ammount;
	String mode;
	String remarks;
	String username;
	String password;
	
	public TransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TransactionRequest(long senderAID, long receiverAID, double ammount, String mode, String remarks,
			String username, String password) {
		super();
		this.senderAID = senderAID;
		this.receiverAID = receiverAID;
		this.ammount = ammount;
		this.mode = mode;
		this.remarks = remarks;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getSenderAID() {
		return senderAID;
	}
	public void setSenderAID(long senderAID) {
		this.senderAID = senderAID;
	}
	public long getReceiverAID() {
		return receiverAID;
	}
	public void setReceiverAID(long receiverAID) {
		this.receiverAID = receiverAID;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
