package com.bankline.bankline.data.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String nome;

	private String cpf;

	private String senhaTemp;
	
	private String login;

	@Column(name = "is_redefinir_senha")
	private Boolean isRedefinirSenha;

	@Column(name = "dt_ultimo_login")
	private LocalDateTime dataUltimoLogin;

	@Column(name = "is_usuario_ativo")
	private Boolean isAtivo;

	@OneToOne(mappedBy = "dono", cascade = CascadeType.ALL)
	private Conta conta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", nullable = false)
	@JsonIgnore
	private UsuarioLogin usuarioLogin;

}