package com.swisbank.bannkapp.entity;

public class AuthStatus {
	private boolean success;
	private int errcode;
	private Long uid;
	private String accessToken;
	public AuthStatus(boolean success, int errcode, Long uid) {
		super();
		this.success = success;
		this.errcode = errcode;
		this.uid = uid;
		accessToken=null;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
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
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	
}
