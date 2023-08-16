package com.swisbank.bannkapp.entity;

public class AuthReq {
	private String email;
	private String passwordHash;
	public AuthReq(String email, java.lang.String passwordHash) {
		super();
		this.email=email;
		this.passwordHash = passwordHash;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	
}
