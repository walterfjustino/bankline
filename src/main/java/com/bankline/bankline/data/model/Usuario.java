package com.bankline.bankline.data.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "usuario_nome", nullable = false)
	private String nome;

	@Column(name = "usuario_cpf", nullable = false, unique = true)
	private String cpf;

	@Column(name = "usuario_login", nullable = false, unique = true, length = 20)
	private String login;

	@Column(name = "usuario_senha", nullable = false)
	private String senha;

	@Column(name = "usuario_senha_temp", nullable = false)
	private String senhaUsuarioTemp;

	@Column(name = "is_redefinir_senha")
	private Boolean isRedefinirSenha;

	@Column(name = "dt_ultimo_login")
	private LocalDateTime dataUltimoLogin;

	@Column(name = "is_usuario_ativo", nullable = false)
	private Boolean isAtivo;

	@OneToOne(mappedBy = "dono")
	private Conta conta;

}