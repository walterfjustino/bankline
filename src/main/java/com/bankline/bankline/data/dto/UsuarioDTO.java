package com.bankline.bankline.data.dto;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.bankline.bankline.data.model.Conta;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
	
	
	private Long idUsuario;
	
	@NotBlank
	@Size(min = 5, max = 200, message = "Preencher o Nome completo")
	private String nomeUsuario;
	
	@NotBlank
	@Max(value = 11)
	@Min(value = 11)
	private String cpfUsuario;
	
	@NotBlank
	@Size(min = 8,max = 20, message = "Login deve conter Minimo 5 Maximo 20 caracteres")
	private String loginUsuario;
	
	@NotBlank
	private String senhaUsuario;
	
	private String senhaUsuarioTemp;
	private Boolean isRedefinirSenha;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDateTime dataUltimoLogin;
	
	@NotNull
	private Boolean isAtivoUsuario;
	
	@Valid
	private Conta contaUsuario;

	
	

	
	

}
