package com.kainattu.portal.service.dto.auth;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Palanivel Muthug Gounder
 *
 */
@Setter
@Getter
@ToString
public class UserDTO {
	private String username;
	private String password;
	private String email;
	private long mobileNo;
	private List<String> roles;

}