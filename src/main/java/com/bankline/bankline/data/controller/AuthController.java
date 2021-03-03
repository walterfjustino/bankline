package com.bankline.bankline.data.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.bankline.data.dto.LoginResponseDTO;
import com.bankline.bankline.data.model.Credentials;
import com.bankline.bankline.data.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/api/login")
	public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody @Valid Credentials credentials) {
		final LoginResponseDTO loginResponseDTO = authService.authenticate(credentials);
		return ResponseEntity.ok(loginResponseDTO);
	}
}
