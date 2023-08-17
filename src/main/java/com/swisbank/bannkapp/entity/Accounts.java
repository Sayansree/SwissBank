package com.swisbank.bannkapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
enum AccState{
	PROCESSING,
	ACTIVE,
	SUSPENDED
}
@Entity
public class Accounts {
	@Id
	@Column(name="accountID",length=11,nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long accountID;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userID")
	//@Column(name="userID", length=11,nullable=false,unique=false)
	private User owner;
	
	@Column(name="balance", precision=20)
	private double balance;
	
	@Column(name="state")
	@Enumerated(EnumType.STRING)
	private AccState state; 
}
