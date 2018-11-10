package com.writer0713.exception;

public class CustomException extends RuntimeException {

	public CustomException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "CustomException error message : " + super.getMessage();
	}
}
