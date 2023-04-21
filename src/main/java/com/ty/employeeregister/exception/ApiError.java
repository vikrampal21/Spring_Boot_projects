package com.ty.employeeregister.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {
	
	private LocalDateTime dateTime;
	private HttpStatus httpStatus;
	private String message;
	private String path;
	

}
