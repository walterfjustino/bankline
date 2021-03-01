package com.bankline.bankline.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankline.bankline.data.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuarios u WHERE u.loginUsuario = :loginUsuario")
	
	List<Usuario> findByLoginUsuario(String loginUsuario);

}
