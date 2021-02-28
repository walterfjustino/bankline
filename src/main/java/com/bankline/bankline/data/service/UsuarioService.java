package com.bankline.bankline.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.dto.MessageResponseDTO;
import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.mapper.UsuarioMapper;
import com.bankline.bankline.data.model.Usuario;
import com.bankline.bankline.data.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	//Metodo Post - cadastrar usuario
	public MessageResponseDTO cadastrar(UsuarioDTO usuarioDTO) {
		
		Usuario usuarioToSalvar = usuarioMapper.toModel(usuarioDTO);
		
		Usuario usuarioSalvo = usuarioRepository.save(usuarioToSalvar);
		return MessageResponseDTO.builder().message("Usuário cadastrado ID: " + usuarioSalvo.getIdUsuario()).build();
			
	}

}
