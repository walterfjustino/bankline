package com.bankline.bankline.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankline.bankline.data.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
