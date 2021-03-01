package com.bankline.bankline.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.dto.MessageResponseDTO;
import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.dto.UsuarioAlterarSenhaDTO;
import com.bankline.bankline.data.dto.UsuarioNovaSenhaDTO;
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
	/*
	//Metodo Post - Alterar a senha do usuario
	public MessageResponseDTO alterarSenha(UsuarioDTO usuarioDTO) {
		
		String senhaAlterada = usuarioMapper.toModel(usuarioDTO).getSenhaUsuario();
		
		Usuario usuarioAlterandoSenha = usuarioMapper.toModel(usuarioDTO).setSenhaUsuario(senhaAlterada);
		
		Usuario usuarioSelecionado = usuarioRepository.save(usuarioAlterandoSenha);
		
		if(usuarioDTO.getIsAtivoUsuario()) {
			return MessageResponseDTO.builder().message("Senha Alterada ID: " + usuarioSelecionado.getIdUsuario()).build();	
		}
	}
	//Metodo Post - Pedir nova senha para o usuario
	public MessageResponseDTO novaSenha(UsuarioDTO usuarioDTO) {
		
		String senhaTemporariaCadastrada = usuarioMapper.toModel(usuarioDTO).getSenhaUsuarioTemp();
		
		Usuario usuarioCadastrandoNovaSenha = usuarioMapper.toModel(usuarioDTO).setSenhaUsuarioTemp(senhaTemporariaCadastrada);;
		
		Usuario usuarioSelecionado = usuarioRepository.save(usuarioCadastrandoNovaSenha);
		if(usuarioDTO.getIsAtivoUsuario()) {
			return MessageResponseDTO.builder().message("Nova Senha Alterada ID: " + usuarioSelecionado.getIdUsuario()).build();
		}
	}
	*/
	
	//Metodo Post - cadastrar usuario
	public MessageResponseDTO cadastrar(UsuarioDTO usuarioDTO) {
		
		Usuario usuarioToSalvar = usuarioMapper.toModel(usuarioDTO);
		
		Usuario usuarioSalvo = usuarioRepository.save(usuarioToSalvar);
		return MessageResponseDTO.builder().message("Usuário cadastrado ID: " + usuarioSalvo.getIdUsuario()).build();
			
	}

}
