package com.swisbank.bannkapp.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="accdetails")
public class AccountDetails {
	@Id
	@Column(name="accid",nullable=false,unique=true)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long accid;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name="accid")
	@JsonIgnore
	private Accounts account;
	
	
	@Column(name="adhar",length=12,nullable=false,unique=true)
	private long adharCard;
	
	@Column(name="phone",length=10,nullable=false,unique=false)
	private long mobile;
	
	@Column(name="gross_anual_income",length=12,nullable=false,unique=false)
	private long grossAnualIncome;
	
	@Column(name="addrRes",length=255,nullable=false,unique=false)
	private String addrRes;
	
	@Column(name="addrPer",length=255,nullable=false,unique=false)
	private String addrPer;
	
	@Column(name="first_name",length=20,nullable=false,unique=false)
	private String firstName;
	
	@Column(name="middle_name",length=20,nullable=false,unique=false)
	private String middleName;
	
	@Column(name="last_name",length=20,nullable=false,unique=false)
	private String lastName;
	
	@Column(name="fathers_name",length=60,nullable=false,unique=false)
	private String fathersName;
	
	@Column(name="occ_type",length=20,nullable=false,unique=false)
	private String occType;
	
	@Column(name="src_inc",length=20,nullable=false,unique=false)
	private String srcInc;
	
	@Column(name="dob",length=20,nullable=false,unique=false)
	private Date dob;
	
	@Column(name="title",length=20,nullable=false,unique=false)
	private String title;

	public long getAccid() {
		return accid;
	}

	public void setAccid(long accid) {
		this.accid = accid;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public long getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(long adhar) {
		this.adharCard = adhar;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long phone) {
		this.mobile = phone;
	}

	public long getGrossAnualIncome() {
		return grossAnualIncome;
	}

	public void setGrossAnualIncome(long anualincome) {
		this.grossAnualIncome = anualincome;
	}

	

	public String getAddrRes() {
		return addrRes;
	}

	public void setAddrRes(String addrRes) {
		this.addrRes = addrRes;
	}

	public String getAddrPer() {
		return addrPer;
	}

	public void setAddrPer(String addrPer) {
		this.addrPer = addrPer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middlename) {
		this.middleName = middlename;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersname) {
		this.fathersName = fathersname;
	}

	public String getOccType() {
		return occType;
	}

	public void setOccType(String occtype) {
		this.occType = occtype;
	}

	public String getSrcInc() {
		return srcInc;
	}

	public void setSrcInc(String srcinc) {
		this.srcInc = srcinc;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public AccountDetails(long accid, Accounts account, long adharCard, long mobile, long grossAnualIncome,
			String addrRes, String addrPer, String firstName, String middleName, String lastName, String fathersName,
			String occType, String srcInc, Date dob, String title) {
		super();
		this.accid = accid;
		this.account = account;
		this.adharCard = adharCard;
		this.mobile = mobile;
		this.grossAnualIncome = grossAnualIncome;
		this.addrRes = addrRes;
		this.addrPer = addrPer;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.fathersName = fathersName;
		this.occType = occType;
		this.srcInc = srcInc;
		this.dob = dob;
		this.title = title;
	}

	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
