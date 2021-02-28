package com.bankline.bankline.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SaldoInsulficienteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SaldoInsulficienteException() {
		
		super(String.format("Saldo insuficiente para transação."));
		
	}

}
