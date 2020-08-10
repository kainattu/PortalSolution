package com.kainattu.portal.service.controller.auth;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kainattu.portal.service.config.auth.JwtTokenUtil;
import com.kainattu.portal.service.config.exception.AuthendicationException;
import com.kainattu.portal.service.config.exception.AuthendicationException.ReasonCode;
import com.kainattu.portal.service.dto.auth.UserDTO;
import com.kainattu.portal.service.model.auth.DAOUser;
import com.kainattu.portal.service.model.auth.JwtRequest;
import com.kainattu.portal.service.model.auth.JwtResponse;
import com.kainattu.portal.service.service.auth.JwtUserDetailsService;

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
		boolean firstTimeLogin = userDetailsService.validateFirstTimeLogin(authenticationRequest.getUsername());
		if(!firstTimeLogin) {
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			final String token = jwtTokenUtil.generateToken(userDetails);
			JwtResponse response = new JwtResponse(token);
			response.setUsername(userDetails.getUsername());
			return ResponseEntity.ok(response);
		}
		else {
			JwtResponse response = new JwtResponse("");
			response.setFirstTimeLogin(true);
			return ResponseEntity.ok(response);
		}
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ResponseEntity<?> resetPassword(@RequestBody JwtRequest authenticationRequest) throws Exception {
		boolean firstTimeLogin = userDetailsService.validateFirstTimeLogin(authenticationRequest.getUsername());
		if(firstTimeLogin) {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			DAOUser user = userDetailsService.updatePassword(authenticationRequest);
			return ResponseEntity.ok(user);
		}
		return null;
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new AuthendicationException(e, ReasonCode.USER_DISABLED);
		} catch (BadCredentialsException e) {
			throw new AuthendicationException(e, ReasonCode.INVALID_CREDENTIALS);
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<?> hello(HttpServletRequest req) throws Exception {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("Test", "Hello");
		return ResponseEntity.ok(map);
	}

	@RequestMapping(value = "/admin/getAllUser", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUser() throws Exception {
		List list = userDetailsService.getAllUser();
		return ResponseEntity.ok(userDetailsService.getAllUser());
	}

	@RequestMapping(value = "/user/getUser", method = RequestMethod.POST)
	public ResponseEntity<?> getAllUser(@RequestParam String username) throws Exception {
		DAOUser user = userDetailsService.getUser(username);
		return ResponseEntity.ok(user);
	}
}