package com.springBoot.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
	
	private String email;
	
	private long mobileNo;

	//private String roles;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_role",
	joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id",
					nullable = false, updatable = false)},
	inverseJoinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id",
					nullable = false, updatable = false)})
	@JsonManagedReference
	private Set<DAORole> roles = new HashSet<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<DAORole> getRoles() {
		return roles;
	}

	public void setRoles(Set<DAORole> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

	//	public String getRoles() {
	//		return roles;
	//	}
	//
	//	public void setRoles(String roles) {
	//		this.roles = roles;
	//	}
	//	


}
