package com.swisbank.bannkapp.entity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User implements UserDetails{
	
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
	//@JsonIgnore
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private String passwordHash;
	
	@Column(name="phone",length=10,nullable=false,unique=false)
	private Long phone;
	
	@Column(name="email",length=50,nullable=false,unique=true)
	private String email;
	
	@Column(name="name",length=50,nullable=false,unique=false)
	private String name;
	
	@OneToMany(mappedBy="owner")
	@JsonIgnore
	private List<Accounts> accnts;
	
	@Column(name="role",nullable=false)
	@Enumerated(EnumType.STRING)
	private Roles role;
	
		public User() {
			role=Roles.USER;
		}
	
		
		


		public Roles getRole() {
			return role;
		}


		public void setRole(Roles role) {
			this.role = role;
		}


		public User(int userID, String passwordHash, Long phone, String email, String name, List<Accounts> accnts,
				Roles role) {
			super();
			this.userID = userID;
			this.passwordHash = passwordHash;
			this.phone = phone;
			this.email = email;
			this.name = name;
			this.accnts = accnts;
			this.role = role;
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
	//	@JsonIgnore
		public String getPasswordHash() {
			return passwordHash;
		}
		//@JsonProperty
		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
		@Override
		public String toString() {
			return "User [userID=" + userID + ", passwordHash=" + passwordHash + "]";
		}


		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return List.of(new SimpleGrantedAuthority(role.name()));
		}


		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return passwordHash;
		}


		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return String.valueOf(userID);
		}


		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}


		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
}
