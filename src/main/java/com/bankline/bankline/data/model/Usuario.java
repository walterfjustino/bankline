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
	
	
	/*
	 * Não é necessário setar se o usuário está ativo ao instanciar um novo Usuário. Basta preencher os demais campos
	 */
/*	public Usuario() {
		
		this.isAtivoUsuario = true;
		
	}*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario")
	private Long idUsuario;
	
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

	
/*	//Getters e Setters
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
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

	//Hash code e equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contaUsuario == null) ? 0 : contaUsuario.hashCode());
		result = prime * result + ((cpfUsuario == null) ? 0 : cpfUsuario.hashCode());
		result = prime * result + ((dataUltimoLogin == null) ? 0 : dataUltimoLogin.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((isAtivoUsuario == null) ? 0 : isAtivoUsuario.hashCode());
		result = prime * result + ((isRedefinirSenha == null) ? 0 : isRedefinirSenha.hashCode());
		result = prime * result + ((loginUsuario == null) ? 0 : loginUsuario.hashCode());
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		result = prime * result + ((senhaUsuario == null) ? 0 : senhaUsuario.hashCode());
		result = prime * result + ((senhaUsuarioTemp == null) ? 0 : senhaUsuarioTemp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (contaUsuario == null) {
			if (other.contaUsuario != null)
				return false;
		} else if (!contaUsuario.equals(other.contaUsuario))
			return false;
		if (cpfUsuario == null) {
			if (other.cpfUsuario != null)
				return false;
		} else if (!cpfUsuario.equals(other.cpfUsuario))
			return false;
		if (dataUltimoLogin == null) {
			if (other.dataUltimoLogin != null)
				return false;
		} else if (!dataUltimoLogin.equals(other.dataUltimoLogin))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (isAtivoUsuario == null) {
			if (other.isAtivoUsuario != null)
				return false;
		} else if (!isAtivoUsuario.equals(other.isAtivoUsuario))
			return false;
		if (isRedefinirSenha == null) {
			if (other.isRedefinirSenha != null)
				return false;
		} else if (!isRedefinirSenha.equals(other.isRedefinirSenha))
			return false;
		if (loginUsuario == null) {
			if (other.loginUsuario != null)
				return false;
		} else if (!loginUsuario.equals(other.loginUsuario))
			return false;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		if (senhaUsuario == null) {
			if (other.senhaUsuario != null)
				return false;
		} else if (!senhaUsuario.equals(other.senhaUsuario))
			return false;
		if (senhaUsuarioTemp == null) {
			if (other.senhaUsuarioTemp != null)
				return false;
		} else if (!senhaUsuarioTemp.equals(other.senhaUsuarioTemp))
			return false;
		return true;
	}
	
	//toString

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", cpfUsuario=" + cpfUsuario
				+ ", loginUsuario=" + loginUsuario + ", senhaUsuario=" + senhaUsuario + ", senhaUsuarioTemp="
				+ senhaUsuarioTemp + ", isRedefinirSenha=" + isRedefinirSenha + ", dataUltimoLogin=" + dataUltimoLogin
				+ ", isAtivoUsuario=" + isAtivoUsuario + ", contaUsuario=" + contaUsuario + "]";
	}*/
	
	}