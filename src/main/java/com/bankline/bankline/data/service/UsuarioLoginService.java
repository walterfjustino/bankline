package com.bankline.bankline.data.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.model.UsuarioLogin;
import com.bankline.bankline.data.repository.UsuarioLoginRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioLoginService {

    private final UsuarioLoginRepository usuarioLoginRepository;

    public UsuarioLogin findByUsername(String username) {
        return this.usuarioLoginRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário " + username + "não encontrado"));
    }
}
