package com.kainattu.portal.service.model.auth;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String jwttoken;
	private final long tokenExpiry = 5 * 60 * 60;
	private String username;
	private String email;
	
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public String getToken() {
		return this.jwttoken;
	}
	public long getTokenExpiry() {
		return tokenExpiry;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}