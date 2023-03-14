package com.axis.exception;

public class DateNotFoundException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public DateNotFoundException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
	
	
	

}
