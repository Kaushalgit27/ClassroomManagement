package com.ty.project.presentation.exception;

public class RatingException extends RuntimeException  {
	
	private String message;
	
	public RatingException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	

}
