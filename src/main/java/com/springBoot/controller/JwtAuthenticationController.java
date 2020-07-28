package com.springBoot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.config.JwtTokenUtil;
import com.springBoot.dto.UserDTO;
import com.springBoot.model.DAOUser;
import com.springBoot.model.JwtRequest;
import com.springBoot.model.JwtResponse;
import com.springBoot.service.JwtUserDetailsService;
@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		JwtResponse response = new JwtResponse(token);
		response.setUsername(userDetails.getUsername());
		return ResponseEntity.ok(response);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<?> hello() throws Exception {
		return ResponseEntity.ok("hello");
	}
	
	@RequestMapping(value = "/admin/getAllUser", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUser() throws Exception {
		List list = userDetailsService.getAllUser();
		return ResponseEntity.ok(userDetailsService.getAllUser());
	}
	
	@RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUser(@RequestParam String username) throws Exception {
		DAOUser user = userDetailsService.getUser(username);
		return ResponseEntity.ok(user);
	}
}