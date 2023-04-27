package com.ty.houserental.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private T data;
	private HttpStatus httpStatus;
	private String message;
	private int code;
}
