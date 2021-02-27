package com.bankline.bankline.data.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "transacao")
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idTransacao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conta_origem_transacao")
	private Conta contaOrigemTransacao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_plano_conta_transacao")
	private PlanoConta planoContaTransacao;
	
	@Column(name = "dt_lancamento_transacao", nullable = false)
	private Date dtLancamentoTransacao;
	
	@Column(name = "valor_transacao", nullable = false)
	private Double valorTransacao;
	
	@Column(name = "descricao_transacao", nullable = false, length = 40)
	private String descricaoTransacao;
	
	@ManyToOne
	@JoinColumn(name = "id_conta_destino")
	private Conta contaDestino;
	
	@CreationTimestamp //Seta automaticamente a data ao instanciar o objeto
	@Column(name = "dt_criacao_transacao", nullable = false)
	private Date dtCadastroTransacao;

	public Long getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(Long idTransacao) {
		this.idTransacao = idTransacao;
	}

	public Conta getContaOrigemTransacao() {
		return contaOrigemTransacao;
	}

	public void setContaOrigemTransacao(Conta contaOrigemTransacao) {
		this.contaOrigemTransacao = contaOrigemTransacao;
	}

	public PlanoConta getPlanoContaTransacao() {
		return planoContaTransacao;
	}

	public void setPlanoContaTransacao(PlanoConta planoContaTransacao) {
		this.planoContaTransacao = planoContaTransacao;
	}

	public Date getDtLancamentoTransacao() {
		return dtLancamentoTransacao;
	}

	public void setDtLancamentoTransacao(Date dtLancamentoTransacao) {
		this.dtLancamentoTransacao = dtLancamentoTransacao;
	}

	public Double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(Double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getDescricaoTransacao() {
		return descricaoTransacao;
	}

	public void setDescricaoTransacao(String descricaoTransacao) {
		this.descricaoTransacao = descricaoTransacao;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	public Date getDtCadastroTransacao() {
		return dtCadastroTransacao;
	}

	public void setDtCadastroTransacao(Date dtCadastroTransacao) {
		this.dtCadastroTransacao = dtCadastroTransacao;
	}

}
