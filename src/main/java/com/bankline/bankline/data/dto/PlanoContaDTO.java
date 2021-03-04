package com.bankline.bankline.data.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.bankline.bankline.data.enums.TipoPlanoContaEnum;
import com.bankline.bankline.data.model.Transacao;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlanoContaDTO {
	
	private Long idPlanoConta;
		
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
	


}
