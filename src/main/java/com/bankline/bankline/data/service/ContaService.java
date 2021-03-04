package com.bankline.bankline.data.service;

import com.bankline.bankline.data.model.ContaModel;
import com.bankline.bankline.data.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.entity.Conta;
import com.bankline.bankline.data.entity.Usuario;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	public ContaService(ContaRepository contaRepository){
		this.contaRepository = contaRepository;

	}


	public Boolean cadastrar(ContaModel contaModel){
		Conta conta = new Conta();
		conta.setId(conta.getId());
		conta.setDono(conta.getDono());
		conta.setSaldo(conta.getSaldo());
		this.contaRepository.save(conta);
		return Boolean.TRUE;
	}

}


