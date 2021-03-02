package com.bankline.bankline.data.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.model.Usuario;
import com.bankline.bankline.data.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Usuario> newUser(@RequestBody UsuarioDTO usuarioDto) {
		Usuario savedUsuario = this.usuarioService.cadastrar(usuarioDto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUsuario.getId())
				.toUri();

		return ResponseEntity.created(uri).build();

	}

}
