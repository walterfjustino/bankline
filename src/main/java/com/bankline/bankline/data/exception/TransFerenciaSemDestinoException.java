package com.bankline.bankline.data.exception;

public class TransFerenciaSemDestinoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TransFerenciaSemDestinoException() {
		
		super(String.format("Destino da transação não informado."));
		
	}

}
