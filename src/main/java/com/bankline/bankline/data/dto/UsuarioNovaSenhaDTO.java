package com.bankline.bankline.data.dto;

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
public class UsuarioNovaSenhaDTO {

	private Long idUsuario; 
	private boolean isAtivoUsuario;
	@NotBlank(message = "Login e obrigatorio")
	@Size(min = 8,max = 20, message = "Login deve conter Minimo 5 Maximo 20 caracteres")
	private String loginUsuario;
	@NotBlank(message = "Nova Senha nao pode ser em branco")
	private String senhaUsuarioTemp;

}
