package com.swisbank.bannkapp.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="userID",length=11,nullable=false,unique=true)
	private int userID;
	
	public List<Accounts> getAccnts() {
		return accnts;
	}


	public void setAccnts(List<Accounts> accnts) {
		this.accnts = accnts;
	}
	@Column(name="passwordHash",length=255, nullable=false,unique=false)
	private String passwordHash;
	
	@Column(name="phone",length=10,nullable=false,unique=false)
	private Long phone;
	
	@Column(name="email",length=50,nullable=false,unique=true)
	private String email;
	
	@Column(name="name",length=50,nullable=false,unique=false)
	private String name;
	
	@OneToMany(mappedBy="owner")
	private List<Accounts> accnts;
		
		public User() {
			
		}
		
		
		public User(int userID, String passwordHash, Long phone, String email, String name) {
			super();
			this.userID = userID;
			this.passwordHash = passwordHash;
			this.phone = phone;
			this.email = email;
			this.name = name;
		}


		public Long getPhone() {
			return phone;
		}


		public void setPhone(Long phone) {
			this.phone = phone;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		@Override
		public int hashCode() {
			return Objects.hash(phone, email, name, passwordHash);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(phone, other.phone) && Objects.equals(email, other.email)
					&& Objects.equals(name, other.name) && Objects.equals(passwordHash, other.passwordHash);
		}


		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public String getPasswordHash() {
			return passwordHash;
		}
		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
		@Override
		public String toString() {
			return "User [userID=" + userID + ", passwordHash=" + passwordHash + "]";
		}
		
}
