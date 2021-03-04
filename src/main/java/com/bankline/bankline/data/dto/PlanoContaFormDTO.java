package com.bankline.bankline.data.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bankline.bankline.data.enums.TipoPlanoContaEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(Include.NON_NULL)
public class PlanoContaFormDTO {
	
	@NotBlank
	private String login;
	@NotBlank
	private String descricao;
	@NotNull
	private boolean padrao;
	@NotNull
	private TipoPlanoContaEnum tipo;
	private boolean ativo;
	private Long id;

}
