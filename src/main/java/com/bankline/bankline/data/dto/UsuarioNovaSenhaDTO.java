package com.bankline.bankline.data.dto;

import javax.validation.constraints.NotBlank;

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
	@NotBlank
	private String loginUsuario;
	@NotBlank
	private String senhaUsuario;
	@NotBlank
	private String novaSenhaUsuario;
	@NotBlank
	private String confirmarNovaSenha;

}
