package com.bankline.bankline.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NovaSenhaRespostaDTO {
	
	private String email;
	private String senhaTemp;
	

}
