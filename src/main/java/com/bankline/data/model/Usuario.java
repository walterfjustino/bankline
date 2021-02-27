package com.bankline.data.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "usuarios")
public class Usuario {
	
	
	/*
	 * Não é necessário setar se o usuário está ativo ao instanciar um novo Usuário. Basta preencher os demais campos
	 */
	public Usuario() {
		
		this.isAtivoUsuario = true;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "usuario_nome", nullable = false)
	private String nomeUsuario;
	
	@Column(name = "usuario_cpf", nullable = false, unique = true)
	private String cpfUsuario;
	
	@Column(name = "usuario_login", nullable = false, unique = true, length = 20)
	private String loginUsuario;
	
	@Column(name = "usuario_senha", nullable = false)
	private String senhaUsuario;
	
	@Column(name = "usuario_senha_temp", nullable = false)
	private String senhaUsuarioTemp;
	
	@Column(name = "is_redefinir_senha")
	private Boolean isRedefinirSenha;
	
	@Column(name = "dt_ultimo_login")
	private LocalDateTime dataUltimoLogin;
	
	@Column(name = "is_usuario_ativo", nullable = false)
	private Boolean isAtivoUsuario;
	
	@OneToOne(mappedBy = "dono")
	private Conta contaUsuario;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public LocalDateTime getDataUltimoLogin() {
		return dataUltimoLogin;
	}

	public void setDataUltimoLogin(LocalDateTime dataUltimoLogin) {
		this.dataUltimoLogin = dataUltimoLogin;
	}

	public Boolean isAtivoUsuario() {
		return isAtivoUsuario;
	}

	public void setAtivoUsuario(Boolean isAtivoUsuario) {
		this.isAtivoUsuario = isAtivoUsuario;
	}

	public String getSenhaUsuarioTemp() {
		return senhaUsuarioTemp;
	}

	public void setSenhaUsuarioTemp(String senhaUsuarioTemp) {
		this.senhaUsuarioTemp = senhaUsuarioTemp;
	}

	public Boolean getIsRedefinirSenha() {
		return isRedefinirSenha;
	}

	public void setIsRedefinirSenha(Boolean isRedefinirSenha) {
		this.isRedefinirSenha = isRedefinirSenha;
	}

	public Boolean getIsAtivoUsuario() {
		return isAtivoUsuario;
	}

	public void setIsAtivoUsuario(Boolean isAtivoUsuario) {
		this.isAtivoUsuario = isAtivoUsuario;
	}

	public Conta getContaUsuario() {
		return contaUsuario;
	}

	public void setContaUsuario(Conta contaUsuario) {
		this.contaUsuario = contaUsuario;
	}
	
}