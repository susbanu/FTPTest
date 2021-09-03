package com.test.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	private String errorCode;
	
	
	public ApplicationException(String errorMessage) {
		super(errorMessage);
	}
	
	public ApplicationException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.setErrorCode(errorCode);
		this.setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
