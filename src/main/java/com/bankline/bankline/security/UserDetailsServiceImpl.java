package com.bankline.bankline.security;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.repository.UsuarioLoginRepository;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioLoginRepository usuarioLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.usuarioLoginRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário " + username + "não encontrado"));

    }

}
