package com.bankline.bankline.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankline.bankline.data.model.PlanoConta;
import com.bankline.bankline.data.model.Usuario;

@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {
	
	
	/*
	 * Busca todos os plano de contas que o usuário criou 
	 * ou que não possuem criador (estes serão adicionados via migration) 
	 */
	@Query("SELECT pc FROM PlanoConta"
		 + " WHERE pc.usuarioCriador = :usuarioCriador"
		 + " OR pc.usuarioCriador = NULL")
	List<PlanoConta> findByUsuarioCriadorEPlanosPadroes(Usuario usuarioCriador);

}
