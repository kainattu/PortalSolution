package com.springBoot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "role")
public class DAORole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String role;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<DAOUser> users = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<DAOUser> getUsers() {
		return users;
	}

	public void setUsers(Set<DAOUser> users) {
		this.users = users;
	}
	
	

}
