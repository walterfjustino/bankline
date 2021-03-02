package com.bankline.bankline.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.br.CPF;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UsuarioDTO {

	@NotBlank
	@Size(min = 3, max = 200, message = "Preencher o Nome completo")
	private String nome;

	//@CPF
	private String cpf;

	@Size(min = 8, max = 20, message = "Login deve conter Minimo 5 Maximo 20 caracteres")
	private String login;
	
	@NotBlank
	private String senha;

}
