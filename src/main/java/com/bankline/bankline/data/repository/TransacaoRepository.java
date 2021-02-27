package com.bankline.bankline.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankline.bankline.data.model.Conta;
import com.bankline.bankline.data.model.PlanoConta;
import com.bankline.bankline.data.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
	
	List<Transacao> findByContaOrigemTransacao(Conta contaOrigemTransacao);
	
	List<Transacao> findByContaOrigemTransacaoAndPlanoContaTransacao(Conta origem, PlanoConta planoConta);
	
	List<Transacao> findByContaOrigemTransacaoAndDtLancamentoTransacao(Conta contaOrigemTransacao, Date dataInicial, Date dataFinal);

}
