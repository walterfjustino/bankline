package com.bankline.bankline.data.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bankline.bankline.data.enums.TipoPlanoContaEnum;

@Entity
@Table(name = "plano_conta")
public class PlanoConta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_plano_conta")
	private Long idPlanoConta;
	
	@Column(name = "descricao_plano_conta", nullable = false, length = 15)
	private String descPlanoConta;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tp_plano_conta", nullable = false)
	private TipoPlanoContaEnum tpPlanoConta;
	
	@Column(name = "is_ativo", nullable = false)
	private Boolean isAtivoPlanoConta;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_criador")
	private Usuario usuarioCriador;
	
	@OneToMany(mappedBy = "planoContaTransacao", fetch = FetchType.LAZY)
	public List<Transacao> transacoesPlanoConta;

	public Long getIdPlanoConta() {
		return idPlanoConta;
	}

	public void setIdPlanoConta(Long idPlanoConta) {
		this.idPlanoConta = idPlanoConta;
	}

	public String getDescPlanoConta() {
		return descPlanoConta;
	}

	public void setDescPlanoConta(String descPlanoConta) {
		this.descPlanoConta = descPlanoConta;
	}

	public TipoPlanoContaEnum getTpPlanoConta() {
		return tpPlanoConta;
	}

	public void setTpPlanoConta(TipoPlanoContaEnum tpPlanoConta) {
		this.tpPlanoConta = tpPlanoConta;
	}

	public Boolean getIsAtivoPlanoConta() {
		return isAtivoPlanoConta;
	}

	public void setIsAtivoPlanoConta(Boolean isAtivoPlanoConta) {
		this.isAtivoPlanoConta = isAtivoPlanoConta;
	}

	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public List<Transacao> getTransacoesPlanoConta() {
		return transacoesPlanoConta;
	}

	public void setTransacoesPlanoConta(List<Transacao> transacoesPlanoConta) {
		this.transacoesPlanoConta = transacoesPlanoConta;
	}
	

}
