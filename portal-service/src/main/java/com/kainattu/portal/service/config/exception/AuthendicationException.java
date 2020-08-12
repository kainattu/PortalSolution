package com.kainattu.portal.service.config.exception;

import lombok.ToString;

/**
 * @author Palanivel Muthu Gounder
 *
 */
@ToString
public class AuthendicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5801974627504003074L;

	public enum ReasonCode {
		USER_DISABLED, INVALID_CREDENTIALS;
	}

	private ReasonCode reasonCode;

	public AuthendicationException(ReasonCode reasonCode) {
		this.reasonCode = reasonCode;

	}

	public AuthendicationException(Throwable cause, ReasonCode reasonCode) {
		super(cause);
		this.reasonCode = reasonCode;

	}

}
