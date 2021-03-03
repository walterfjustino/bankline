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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "conta_dono")
	private Usuario dono;
	
	@Column(name = "conta_saldo", nullable = false)
	private Double saldo;
	
	@OneToMany(mappedBy = "contaOrigemTransacao", fetch = FetchType.LAZY)
	private List<Transacao> transacoes;
		
}
