package com.ty.project.presentation.exception;

public class UsernotfoundException extends RuntimeException  {
	private String message;
	
	public UsernotfoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	

}
