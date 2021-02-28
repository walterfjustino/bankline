package com.bankline.bankline.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlanoContaNotFoundException extends Exception {
	
	public PlanoContaNotFoundException(Long idPlanoConta) {
		super(String.format("Plano de Conta não encontrado: ", idPlanoConta));
		
	}

}
