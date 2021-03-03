package com.bankline.bankline.data.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.dto.LoginResponseDTO;
import com.bankline.bankline.data.model.Credentials;
import com.bankline.bankline.data.model.UsuarioLogin;
import com.bankline.bankline.security.JWTUtil;

@Service
@AllArgsConstructor
public class AuthService {

	private final AuthenticationManager authenticationManager;
	private final UsuarioLoginService usuarioLoginService;
	private final JWTUtil jwtUtil;

	public LoginResponseDTO authenticate(Credentials credentials) {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UsuarioLogin user = this.usuarioLoginService.findByUsername(credentials.getUsername());
		final String token = jwtUtil.generateToken(user);
		return LoginResponseDTO.builder().token(token).build();
	}

}
