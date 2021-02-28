package com.bankline.bankline.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoginNaoPertenceAContaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LoginNaoPertenceAContaException() {
		
		super(String.format("O login usado não pertence à conta de origem usada."));
		
	}

}
