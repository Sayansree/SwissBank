package com.swisbank.bannkapp.entity;


import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name="transactions")
public class Transactions {
	@Id
	@Column(name="txid",length=11,nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long txid;
	
//	@Column(name="sender",length=11,nullable=false,unique=true)
//	private long sender;
//	
//	@Column(name="receiver",length=11,nullable=false,unique=true)
//	private long receiver;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sender")
	@JsonIgnore
	private Accounts sender;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="receiver")
	@JsonIgnore
	private Accounts receiver;
	
	@Column(name="medium")
	@Enumerated(EnumType.STRING)
	private TransMed medium;
	
	@Column(name="timestamp",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp timestamp;
	
	@Column(name="remarks",length=255,nullable=false,unique=false)
	private String remarks;
	
	@Column(name="ammount",length=255,nullable=false,unique=false)
	private double ammount;

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

//	public long getSender() {
//		return sender;
//	}
//
//	public void setSender(long sender) {
//		this.sender = sender;
//	}
//
//	public long getReceiver() {
//		return receiver;
//	}
//
//	public void setReceiver(long receiver) {
//		this.receiver = receiver;
//	}

	public TransMed getMedium() {
		return medium;
	}

	public Accounts getSender() {
		return sender;
	}

	public void setSender(Accounts sender) {
		this.sender = sender;
	}

	public Accounts getReceiver() {
		return receiver;
	}

	public void setReceiver(Accounts receiver) {
		this.receiver = receiver;
	}

	public void setMedium(TransMed medium) {
		this.medium = medium;
	}
	public void setMedium(String medium) {
		this.medium = TransMed.valueOf(medium);
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public Transactions(long txid, Accounts sender, Accounts receiver, TransMed medium, Timestamp timestamp,
			String remarks, double ammount) {
		super();
		this.txid = txid;
		this.sender = sender;
		this.receiver = receiver;
		this.medium = medium;
		this.timestamp = timestamp;
		this.remarks = remarks;
		this.ammount = ammount;
	}

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
