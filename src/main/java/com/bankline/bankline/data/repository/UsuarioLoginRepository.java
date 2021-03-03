package com.bankline.bankline.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankline.bankline.data.model.UsuarioLogin;

@Repository
public interface UsuarioLoginRepository  extends JpaRepository<UsuarioLogin, Long> {
	
	Optional<UsuarioLogin> findByUsername(String username);
}
