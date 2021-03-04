package com.bankline.bankline.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Data
@NoArgsConstructor
public class UsuarioModel{

	private Long id;

	@NotBlank
	@Size(min = 3, max = 200, message = "Preencher o Nome completo")
	private String nome;

	@NotBlank
	private String cpf;

	@Size(min = 8, max = 20, message = "Login deve conter Minimo 5 Maximo 20 caracteres")
	private String login;
	
	@NotBlank
	private String senha;

}
