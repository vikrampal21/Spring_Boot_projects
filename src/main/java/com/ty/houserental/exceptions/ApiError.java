package com.ty.houserental.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiError {
	
	private LocalDateTime dateTime;
	private String message;
	private Class<?> getClass;

}
