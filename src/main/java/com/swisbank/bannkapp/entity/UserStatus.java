package com.swisbank.bannkapp.entity;

public class UserStatus {
	boolean success;
	int errcode;
	public UserStatus(boolean success, int errcode) {
		super();
		this.success = success;
		this.errcode = errcode;
	}
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
	
}

