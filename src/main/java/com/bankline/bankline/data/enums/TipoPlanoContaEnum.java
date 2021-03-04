package com.bankline.bankline.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPlanoContaEnum {
	
	R("RECEITA"),	D("DESPESA"),	T("TRANSFERENCIA");

	private final String valor;

}


