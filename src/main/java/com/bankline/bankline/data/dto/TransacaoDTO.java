package com.bankline.bankline.data.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TransacaoDTO {
	
	private Long contaOrigemTransacao;
	
	private Long planoConta;
	
	private String login;
	
	private String contaDestino;
	
	private Double valor;
	
	private String descricao;
	
	private Date dtLancamentoTransacao;

}
