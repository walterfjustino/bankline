package com.bankline.bankline.data.exception;

public class UsuarioNaoInformadoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UsuarioNaoInformadoException() {
	
		super(String.format("Usuario não informado."));

	}

}
