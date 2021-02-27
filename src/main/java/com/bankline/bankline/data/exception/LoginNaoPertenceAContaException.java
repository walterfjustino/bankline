package com.bankline.bankline.data.exception;

public class LoginNaoPertenceAContaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LoginNaoPertenceAContaException() {
		
		super(String.format("O login usado não pertence à conta de origem usada."));
		
	}

}
