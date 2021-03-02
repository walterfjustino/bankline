package com.bankline.bankline.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankline.bankline.data.model.PlanoConta;
import com.bankline.bankline.data.model.Usuario;

@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {
	
	@Query("SELECT pc FROM PlanoConta pc WHERE pc.usuarioCriador = :usuario OR pc.usuarioCriador = NULL")
	List<PlanoConta> findPlanoContaDisponiveis(Usuario usuario);

}
