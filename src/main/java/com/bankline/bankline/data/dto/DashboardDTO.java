package com.bankline.bankline.data.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Builder
@Getter
public class DashboardDTO {
	
	@NotNull
	private UsuarioDTO usuario;
	
	private List<TransacaoDTO> transacoes;

}
