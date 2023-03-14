package com.axis.exception;

public class DuplicateDateFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public DuplicateDateFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	
	
}
