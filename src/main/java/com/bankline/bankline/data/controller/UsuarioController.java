package com.bankline.bankline.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.bankline.data.dto.MessageResponseDTO;
import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public MessageResponseDTO newUser(UsuarioDTO usuario) {
		
		MessageResponseDTO novoUsuario = usuarioService.cadastrar(usuario);
		return novoUsuario;
		
	}
	

}
