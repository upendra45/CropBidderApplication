package com.cg.cbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BidNotFoundException extends RuntimeException
{
	public BidNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BidNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BidNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BidNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}