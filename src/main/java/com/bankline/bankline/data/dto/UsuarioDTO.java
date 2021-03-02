package com.bankline.bankline.data.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

	@NotBlank
	@Size(min = 5, max = 200, message = "Preencher o Nome completo")
	private String nome;

	@NotBlank
	@Max(value = 11)
	@Min(value = 11)
	private String cpf;

	@NotBlank
	@Size(min = 8, max = 20, message = "Login deve conter Minimo 5 Maximo 20 caracteres")
	private String login;

	@NotBlank
	private String senha;

}
