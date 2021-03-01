package com.bankline.bankline.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankline.bankline.data.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	@Query("SELECT c FROM Conta c WHERE c.dono.loginUsuario = :login")
	
	Conta findbyDonoLogin(String login);

}
