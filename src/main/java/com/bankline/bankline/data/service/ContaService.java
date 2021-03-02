package com.bankline.bankline.data.service;

import org.springframework.stereotype.Service;

import com.bankline.bankline.data.model.Conta;
import com.bankline.bankline.data.model.Usuario;

@Service
public class ContaService {
	
	public Conta criar(Usuario usuario) {
		return Conta.builder()
				.dono(usuario)
				.saldo(0.00)
				.transacoes(null)
				.build();
	}

}
