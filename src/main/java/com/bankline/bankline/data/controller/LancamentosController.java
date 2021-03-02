package com.bankline.bankline.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.bankline.data.dto.PlanoContaDTO;
import com.bankline.bankline.data.dto.TransacaoDTO;
import com.bankline.bankline.data.exception.LoginNaoPertenceAContaException;
import com.bankline.bankline.data.exception.SaldoInsulficienteException;
import com.bankline.bankline.data.exception.TransFerenciaSemDestinoException;
import com.bankline.bankline.data.model.Transacao;
import com.bankline.bankline.data.service.TransacaoService;

@RestController
@RequestMapping(value = "lancamentos")
public class LancamentosController {
	
	
	@Autowired
	private TransacaoService transacaoService;
	
	/** "?" curinga, o tipo de responsta ddo controlador aceitará ambos. **/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> newTransaction(TransacaoDTO lancamento){
		
		try {
			
			Transacao transacao = transacaoService.salvar(lancamento);
			return ResponseEntity.ok().body(transacao);
		}
		catch (LoginNaoPertenceAContaException log) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(log);
		}
		catch (TransFerenciaSemDestinoException log) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(log);
		}
		catch (SaldoInsulficienteException log) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(log);
		}

	}
	
	
	//public ResponseEntity<List<PlanoContaDTO>> getPlanosConta(String login){	
	//}
	
	//public ResponseEntity<PlanoContaDTO> newAccount(PlanoContaDTO conta){	
	//}
	

}
