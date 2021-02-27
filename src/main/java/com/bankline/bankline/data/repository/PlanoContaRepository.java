package com.bankline.bankline.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankline.bankline.data.model.PlanoConta;

@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Long> {

}
