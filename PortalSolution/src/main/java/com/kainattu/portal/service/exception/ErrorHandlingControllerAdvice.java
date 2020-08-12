package com.kainattu.portal.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ErrorHandlingControllerAdvice {

  @ExceptionHandler(BadCredentialsException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ResponseBody
  ExceptionMessage onBadCredentialException(
		  BadCredentialsException e) {
    return new ExceptionMessage("BAD_CREDENTIAL", e.getMessage());
  }
  
  @ExceptionHandler({DisabledException.class})
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ResponseBody
  ExceptionMessage onDisabledException(
		  BadCredentialsException e) {
    return new ExceptionMessage("DISABLED", e.getMessage());
  }
  
  @ExceptionHandler({UserAlreadyExistsException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  ExceptionMessage onUserExistsException(
		  UserAlreadyExistsException e) {
    return new ExceptionMessage("USER_EXISTS", e.getMessage());
  }
}