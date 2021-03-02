package com.bankline.bankline.data.exception;

public class UsuarioNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UsuarioNaoEncontradoException() {
		
		super(String.format("Usuario não encontrado."));
		
	}

}
