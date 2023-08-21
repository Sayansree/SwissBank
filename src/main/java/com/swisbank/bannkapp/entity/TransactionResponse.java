package com.swisbank.bannkapp.entity;

public class TransactionResponse {
	private boolean success;
	private int errcode;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
		errcode=0;
		success=true;
		message="transaction complete";
	}
	public TransactionResponse(int errcode) {
		super();
		success=errcode==0; 

		switch(errcode) {
		case 0:message="transaction complete";break;
		case 1:message="incorrect sender account number";break;
		case 2:message="incorrect receipent account number";break;
		case 3:message="sender account isn't ACTIVE";break;
		case 4:message="receiver account isnt ACTIVE";break;
		case 5:message ="insufficient balance";break;
		case 6:message ="ammount cant be negative"; break;
		case 7:message ="internal server error";break;
		}
	}
	
}
