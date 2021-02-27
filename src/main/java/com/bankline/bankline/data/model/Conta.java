package com.bankline.bankline.data.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contas")
public class Conta {
	
	/*
	 * Ao instanciar a conta, não é necessário setar o saldo inicial.
	 */
	public Conta() {
		
		this.saldo = 0.00;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_conta")
	private Long idConta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_dono")
	private Usuario dono;
	
	@Column(name = "conta_saldo", nullable = false)
	private Double saldo;
	
	@OneToMany(mappedBy = "contaTransacao", fetch = FetchType.LAZY)
	private List<Transacao> transacoes;
	
	public Usuario getDono() {
		return dono;
	}
	
	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	
	
		
}
