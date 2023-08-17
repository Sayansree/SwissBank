package com.swisbank.bannkapp.entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

enum TransMed{
	IMPS,
	NEFT,
	RTGS
}

@Entity
@Table(name="transactions")
public class Transactions {
	@Id
	@Column(name="txid",length=11,nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long txid;
	
	@Column(name="sender",length=11,nullable=false,unique=true)
	private long sender;
	
	@Column(name="receiver",length=11,nullable=false,unique=true)
	private long receiver;
	
	@Column(name="medium")
	@Enumerated(EnumType.STRING)
	private TransMed medium;
	
	@Column(name="timestamp",insertable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp timestamp;
	
	@Column(name="remarks",length=255,nullable=false,unique=true)
	private String remarks;

	public long getTxid() {
		return txid;
	}

	public void setTxid(long txid) {
		this.txid = txid;
	}

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Transactions(long txid, long sender, long receiver, TransMed medium, Timestamp timestamp, String remarks) {
		super();
		this.txid = txid;
		this.sender = sender;
		this.receiver = receiver;
		this.medium = medium;
		this.timestamp = timestamp;
		this.remarks = remarks;
	}

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
