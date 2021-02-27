package com.bankline.bankline.data.exception;

public class SaldoInsulficienteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SaldoInsulficienteException() {
		
		super(String.format("Saldo insuficiente para transação."));
		
	}

}
