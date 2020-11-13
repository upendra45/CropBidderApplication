package com.cg.cbs.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//Handle specific exceptions
    @ExceptionHandler(FarmerNotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> farmerNotFoundException(FarmerNotFoundException ex, WebRequest request) {
    	ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }
    
    //Handle specific exceptions
    @ExceptionHandler(CropNotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> cropNotFoundException(CropNotFoundException ex, WebRequest request) {
    	ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    //Handle Global exceptionsS
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> globleExcpetionHandler(Exception ex, WebRequest request) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
