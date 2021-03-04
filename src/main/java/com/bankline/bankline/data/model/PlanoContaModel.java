package com.bankline.bankline.data.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.bankline.bankline.data.enums.TipoPlanoContaEnum;
import com.bankline.bankline.data.entity.Transacao;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlanoContaModel {
	
	private Long idPlanoConta;

	@NotBlank
	@Max(value = 15)
	private String descPlanoConta;
	
	@NotBlank
	private TipoPlanoContaEnum tpPlanoConta;
	
	@NotBlank
	private Boolean isAtivoPlanoConta;
	
	@NotBlank
	private Boolean isPadrao;
	
	@NotBlank
	private String login;
	
	
	public List<Transacao> transacoesPlanoConta;
	


}
