package com.swisbank.bannkapp.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userID")
	private int userID;
	
	@Column(name="passwordHash")
	private String passwordHash;
	
	@Column(name="phone")
	private Long phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
		
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