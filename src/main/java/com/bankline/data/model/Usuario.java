package com.bankline.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idUsuario;
	private String nomeUsuario;
	private String cpfUsuario;
	private String loginUsuario;
	private String tipoLoginUsuario;
	private String senhaUsuario;
	private Date localDateTimeUsuario;
	private boolean isAtivoUsuario;
	
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
	public String getTipoLoginUsuario() {
		return tipoLoginUsuario;
	}
	public void setTipoLoginUsuario(String tipoLoginUsuario) {
		this.tipoLoginUsuario = tipoLoginUsuario;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	public Date getLocalDateTimeUsuario() {
		return localDateTimeUsuario;
	}
	public void setLocalDateTimeUsuario(Date localDateTimeUsuario) {
		this.localDateTimeUsuario = localDateTimeUsuario;
	}
	public boolean isAtivoUsuario() {
		return isAtivoUsuario;
	}
	public void setAtivoUsuario(boolean isAtivoUsuario) {
		this.isAtivoUsuario = isAtivoUsuario;
	}
	
}