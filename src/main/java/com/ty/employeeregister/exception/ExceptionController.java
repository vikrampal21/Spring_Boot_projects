package com.ty.employeeregister.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> constraintException(ConstraintViolationException constraintViolationException,
			HttpServletRequest httpServletRequest) {
		ApiError apiError = new ApiError();
		apiError.setPath(httpServletRequest.getServletPath());
		apiError.setDateTime(LocalDateTime.now());
		apiError.setHttpStatus(HttpStatus.BAD_REQUEST);
		apiError.setMessage(constraintViolationException.getMessage());
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

}
