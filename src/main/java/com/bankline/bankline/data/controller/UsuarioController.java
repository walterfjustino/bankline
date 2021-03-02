package com.bankline.bankline.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.model.Usuario;
import com.bankline.bankline.data.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> newUser(UsuarioDTO usuarioDto) {
		
		Usuario usuario = usuarioService.cadastrar(usuarioDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
		
	}
	

}
