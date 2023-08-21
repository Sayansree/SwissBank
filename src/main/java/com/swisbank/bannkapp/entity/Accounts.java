package com.swisbank.bannkapp.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
//enum AccState{
//	PROCESSING,
//	ACTIVE,
//	SUSPENDED
//}
@Entity
@Table(name="Accounts")
public class Accounts {
	@Id
	@Column(name="accountID",length=11,nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long accountID;
	
	@OneToOne(mappedBy="account")
	@PrimaryKeyJoinColumn
	@JsonIgnore
	private AccountDetails details;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userID")
	@JsonIgnore
	//@Column(name="userID", length=11,nullable=false,unique=false)
	private User owner;
	
	//@OneToMany(fetch=FetchType.LAZY)
	@OneToMany(mappedBy="sender")
	@JsonIgnore
	private List<Transactions> TX;
	
	@OneToMany(mappedBy="receiver")
	@JsonIgnore
	private List<Transactions> RX;
	
	
	@Column(name="balance",nullable=false)
	private double balance;
	
	@Column(name="state")
	@Enumerated(EnumType.STRING)
	private AccState state;

	

	public Accounts(long accountID, AccountDetails details, User owner, List<Transactions> tX, List<Transactions> rX,
			double balance, AccState state) {
		super();
		this.accountID = accountID;
		this.details = details;
		this.owner = owner;
		TX = tX;
		RX = rX;
		this.balance = balance;
		this.state = state;
	}

	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDetails getDetails() {
		return details;
	}

	public void setDetails(AccountDetails details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(RX, TX, accountID, balance, owner, state);
	}

	public long getAccountID() {
		return accountID;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	@JsonIgnore
	public List<Transactions> getTX() {
		return TX;
	}

	public void setTX(List<Transactions> tX) {
		TX = tX;
	}
	@JsonIgnore
	public List<Transactions> getRX() {
		return RX;
	}

	public void setRX(List<Transactions> rX) {
		RX = rX;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccState getState() {
		return state;
	}

	public void setState(AccState state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		return Objects.equals(RX, other.RX) && Objects.equals(TX, other.TX) && accountID == other.accountID
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(owner, other.owner) && state == other.state;
	} 
	
	
}
