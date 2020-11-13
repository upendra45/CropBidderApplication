package com.cg.cbs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BidderNotFoundException extends RuntimeException {

	public BidderNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BidderNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BidderNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BidderNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BidderNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
