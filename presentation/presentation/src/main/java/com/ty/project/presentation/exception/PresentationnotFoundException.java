package com.ty.project.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PresentationnotFoundException extends RuntimeException {
	
private String message;
	
	public PresentationnotFoundException(String message) {
		//super(message);
		this.message=message;
		
	}
	
	
	
	@Override
	public String getMessage() {
		return message;
	}

}
