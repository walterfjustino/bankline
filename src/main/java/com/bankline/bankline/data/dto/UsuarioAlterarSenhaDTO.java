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
public class UsuarioAlterarSenhaDTO {

	private Long idUsuario;
	@NotBlank
	@Query("SELECT c FROM Usuarios c WHERE c.loginUsuario = :loginUsuario")
	private String loginUsuario;
	@NotBlank
	@Query("SELECT c FROM Usuarios c WHERE c.senhaUsuario = :senhaUsuario")
	private String senhaUsuario;

}
