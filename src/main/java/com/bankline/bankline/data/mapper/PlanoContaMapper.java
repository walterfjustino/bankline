package com.bankline.bankline.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bankline.bankline.data.dto.PlanoContaDTO;
import com.bankline.bankline.data.model.PlanoConta;

@Mapper
public interface PlanoContaMapper {
	
	
	PlanoContaMapper INSTANCE = Mappers.getMapper(PlanoContaMapper.class);
	
	PlanoConta toModel(PlanoContaDTO planoContaDTO);
	
	PlanoContaDTO toDTO(PlanoConta planoConta);

}

