package com.hcl.db.exception;

public class EmptyIdException extends RuntimeException {

	private String message;

	public EmptyIdException(String message) {
		// super();
		this.message = message;
	}

}
