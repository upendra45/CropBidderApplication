package com.cg.cbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FarmerNotFoundException extends RuntimeException{

	public FarmerNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public FarmerNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FarmerNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public FarmerNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
