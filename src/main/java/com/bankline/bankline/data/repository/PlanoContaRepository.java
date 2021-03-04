package com.bankline.bankline.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankline.bankline.data.entity.PlanoConta;
import com.bankline.bankline.data.entity.Usuario;

@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {

	@Query("SELECT pc FROM PlanoConta pc WHERE pc.usuarioCriado = :usuario OR pc.usuarioCriado = NULL")
	List<PlanoConta> findPlanoContaDisponiveis(@Param("usuario") Usuario usuario);

}
