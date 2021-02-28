package com.bankline.bankline.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.model.Usuario;

@Mapper
public interface UsuarioMapper {
	
	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	
	Usuario toModel(UsuarioDTO usuarioDTO);
	
	UsuarioDTO toDTO(Usuario usuario);

}
