package com.bankline.bankline.data.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TransacaoModel {


	private Long id;

	@NotNull
	private Long contaOrigemTransacao;

	@NotNull
	private Long planoConta;

	@NotBlank
	private String login;

	@NotBlank
	private String contaDestino;

	@NotNull
	private Double valor;

	@NotBlank
	@Max(value = 20)
	private String descricao;

	@NotBlank
	private Date dtLancamentoTransacao;

}
