package com.bankline.bankline.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.dto.TransacaoDTO;
import com.bankline.bankline.data.enums.TipoPlanoContaEnum;
import com.bankline.bankline.data.exception.LoginNaoPertenceAContaException;
import com.bankline.bankline.data.exception.SaldoInsulficienteException;
import com.bankline.bankline.data.exception.TransFerenciaSemDestinoException;
import com.bankline.bankline.data.model.Conta;
import com.bankline.bankline.data.model.PlanoConta;
import com.bankline.bankline.data.model.Transacao;
import com.bankline.bankline.data.repository.ContaRepository;
import com.bankline.bankline.data.repository.PlanoContaRepository;
import com.bankline.bankline.data.repository.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private TransacaoRepository repository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	
	public Transacao salvar(TransacaoDTO dto) throws LoginNaoPertenceAContaException, 
													 TransFerenciaSemDestinoException,
													 SaldoInsulficienteException {
		
		Conta origem = contaRepository.findById(dto.getContaOrigemTransacao()).get();
		PlanoConta planoConta = planoContaRepository.findById(dto.getPlanoConta()).get();

		if(!origem.getDono().getLoginUsuario().equals(dto.getLogin())) throw new LoginNaoPertenceAContaException();
		
		if(planoConta.getTpPlanoConta().equals(TipoPlanoContaEnum.TRANSFERENCIA) && dto.getContaDestino().equals(null)) throw new TransFerenciaSemDestinoException();
		
		if(!planoConta.getTpPlanoConta().equals(TipoPlanoContaEnum.RECEITA) && origem.getSaldo() - dto.getValor() < 0) throw new SaldoInsulficienteException();
		
		return repository.save(montarTransacao(dto, origem, planoConta));
	
	}

	private Transacao montarTransacao(TransacaoDTO dto, Conta origem, PlanoConta planoConta) {
		
		Transacao transacao = new Transacao();
		
		/*
		 * Calculando o saldo final da conta origem após a transação
		 */
		
		if(planoConta.getTpPlanoConta().equals(TipoPlanoContaEnum.RECEITA)) {
			
			origem.setSaldo(origem.getSaldo() + dto.getValor());
			
		} else {
			
			origem.setSaldo(origem.getSaldo() - dto.getValor());
			
		}
		
		/*
		 * Preenchendo o objeto transação
		 */
		
		transacao.setValorTransacao(dto.getValor());
		transacao.setPlanoContaTransacao(planoConta);
		transacao.setContaOrigemTransacao(origem);
		transacao.setDescricaoTransacao(dto.getDescricao());
		transacao.setDtLancamentoTransacao(dto.getDtLancamentoTransacao());
		
		/*
		 * Se a transação for uma transferência, calculando o saldo final da conta destino e adicionando ao objeto a ser persistido.
		 */
		
		if(planoConta.getTpPlanoConta().equals(TipoPlanoContaEnum.TRANSFERENCIA)) {
			
			Conta destino = contaRepository.findbyDonoLogin(dto.getContaDestino());
			
			destino.setSaldo(destino.getSaldo() + dto.getValor());
			
			transacao.setContaDestino(destino);
			
		}
		
		return transacao;
		
	}

}
