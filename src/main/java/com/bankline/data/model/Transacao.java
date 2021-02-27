package com.bankline.data.model;

import java.util.Date;

public class Transacao {
	
	private int idTransacao;
	private int idContaTransacao;
	private int idPlanoContaTransacao;
	private Date dtLancamentoTransacao;
	private double valorTransacao;
	private String descricaoTransacao;
	private int idContaDestinoTransação;
	private Date dtCadastroTransacao;
	
	public int getIdTransacao() {
		return idTransacao;
	}
	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}
	public int getIdContaTransacao() {
		return idContaTransacao;
	}
	public void setIdContaTransacao(int idContaTransacao) {
		this.idContaTransacao = idContaTransacao;
	}
	public int getIdPlanoContaTransacao() {
		return idPlanoContaTransacao;
	}
	public void setIdPlanoContaTransacao(int idPlanoContaTransacao) {
		this.idPlanoContaTransacao = idPlanoContaTransacao;
	}
	public Date getDtLancamentoTransacao() {
		return dtLancamentoTransacao;
	}
	public void setDtLancamentoTransacao(Date dtLancamentoTransacao) {
		this.dtLancamentoTransacao = dtLancamentoTransacao;
	}
	public double getValorTransacao() {
		return valorTransacao;
	}
	public void setValorTransacao(double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}
	public String getDescricaoTransacao() {
		return descricaoTransacao;
	}
	public void setDescricaoTransacao(String descricaoTransacao) {
		this.descricaoTransacao = descricaoTransacao;
	}
	public int getIdContaDestinoTransação() {
		return idContaDestinoTransação;
	}
	public void setIdContaDestinoTransação(int idContaDestinoTransação) {
		this.idContaDestinoTransação = idContaDestinoTransação;
	}
	public Date getDtCadastroTransacao() {
		return dtCadastroTransacao;
	}
	public void setDtCadastroTransacao(Date dtCadastroTransacao) {
		this.dtCadastroTransacao = dtCadastroTransacao;
	}
	
	
	
	

}
