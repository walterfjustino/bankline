package com.bankline.bankline.data.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bankline.bankline.data.dto.NovaSenhaRespostaDTO;
import com.bankline.bankline.data.dto.UsuarioAlterarSenhaDTO;
import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.dto.UsuarioNovaSenhaDTO;
import com.bankline.bankline.data.exception.UsuarioNaoEncontradoException;
import com.bankline.bankline.data.model.Usuario;
import com.bankline.bankline.data.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;


	@PostMapping("/usuarios")
	public ResponseEntity<?> newUser(@RequestBody UsuarioDTO usuarioDto) {
		Usuario savedUsuario = this.usuarioService.cadastrar(usuarioDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUsuario.getId())
				.toUri();

		return ResponseEntity.created(uri).build();

	}
	
	@PostMapping("/altera-senha")
	public ResponseEntity<?> alterarSenha(@RequestBody UsuarioAlterarSenhaDTO dto) {
		
		try {
			return ResponseEntity.ok(usuarioService.alterarSenha(dto));
		} catch (UsuarioNaoEncontradoException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		
		}
	
	}
	
	@PostMapping("/nova-senha")
	public ResponseEntity<?> renovarSenha(@RequestBody UsuarioNovaSenhaDTO dto) {
		
		NovaSenhaRespostaDTO resposta = NovaSenhaRespostaDTO.builder()
					.email(dto.getEmail())
					.senhaTemp("12345")
					.build();
		
		try {
			
			return usuarioService.solicitarNovaSenha(dto) ? ResponseEntity.ok(resposta) : null;

		} catch (UsuarioNaoEncontradoException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		
		}
	
	}

}
