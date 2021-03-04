package com.bankline.bankline.data.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.bankline.bankline.data.enums.TipoPlanoContaEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
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
