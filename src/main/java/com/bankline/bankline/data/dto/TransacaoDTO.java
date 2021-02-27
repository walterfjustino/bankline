package com.bankline.bankline.data.dto;

import java.util.Date;

public class TransacaoDTO {
	
	private Long contaOrigemTransacao;
	
	private Long planoConta;
	
	private String login;
	
	private String contaDestino;
	
	private Double valor;
	
	private String descricao;
	
	private Date dtLancamentoTransacao;

	public Long getContaOrigemTransacao() {
		return contaOrigemTransacao;
	}

	public void setContaOrigemTransacao(Long contaOrigemTransacao) {
		this.contaOrigemTransacao = contaOrigemTransacao;
	}

	public Long getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(Long planoConta) {
		this.planoConta = planoConta;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtLancamentoTransacao() {
		return dtLancamentoTransacao;
	}

	public void setDtLancamentoTransacao(Date dtLancamentoTransacao) {
		this.dtLancamentoTransacao = dtLancamentoTransacao;
	}

}
