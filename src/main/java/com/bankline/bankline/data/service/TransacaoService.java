package com.bankline.bankline.data.service;

import com.bankline.bankline.data.entity.Conta;
import com.bankline.bankline.data.model.TransacaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankline.bankline.data.entity.Transacao;
import com.bankline.bankline.data.repository.ContaRepository;
import com.bankline.bankline.data.repository.PlanoContaRepository;
import com.bankline.bankline.data.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;


	private final ContaRepository contaRepository;

	@Autowired
	private PlanoContaRepository planoContaRepository;

	@Autowired
	TransacaoService(TransacaoRepository transacaoRepository, ContaRepository contaRepository,
					 PlanoContaRepository planoContaRepository) {
		this.transacaoRepository = transacaoRepository;
		this.contaRepository = contaRepository;
		this.planoContaRepository = planoContaRepository;

	}
}




//	PlanoConta planoConta = this.planoContaRepository.findById(transacaoModel.getPlanoConta()).get();
//	if(transacaoRepository.exists){


//	Conta conta = this.contaRepository.findById(.get();
//	PlanoConta planoConta = this.planoContaRepository.findById(transacaoModel.getPlanoConta()).get();
//	if(transacaoRepository.exists){

/*
	public Transacao salvar(TransacaoDTO dto) throws LoginNaoPertenceAContaException,
													 TransFerenciaSemDestinoException,
													 SaldoInsulficienteException {
		
		Conta origem = contaRepository.findById(dto.getContaOrigemTransacao()).get();
		PlanoConta planoConta = planoContaRepository.findById(dto.getPlanoConta()).get();

		if(!origem.getDono().getLogin().equals(dto.getLogin())) throw new LoginNaoPertenceAContaException();
		
		if(planoConta.getTpPlanoConta().equals(TipoPlanoContaEnum.TRANSFERENCIA) && dto.getContaDestino().equals(null)) throw new TransFerenciaSemDestinoException();
		
		if(!planoConta.getTpPlanoConta().equals(TipoPlanoContaEnum.RECEITA) && origem.getSaldo() - dto.getValor() < 0) throw new SaldoInsulficienteException();
		
		return repository.save(createFromDto(dto, origem, planoConta));
	
	}

	public List<TransacaoDTO> buscarPorIntervalo(Conta origem, Date dtInicial, Date dtFinal) {
		
		List<Transacao> consulta = repository.findByContaOrigemTransacaoAndDtLancamentoTransacao(origem, dtInicial, dtFinal);
		List<TransacaoDTO> dtos = new ArrayList<TransacaoDTO>();
		
		for(Transacao transacao : consulta) {
			
			dtos.add(createFromModel(transacao));
			
		}
		
		return dtos;
		
	}

	private Transacao createFromDto(TransacaoDTO dto, Conta origem, PlanoConta planoConta) {
		
		Transacao transacao = new Transacao();
		
		*/
/*
		 * Calculando o saldo final da conta origem após a transação
		 *//*

		
		if(planoConta.getTpPlanoConta().equals(TipoPlanoContaEnum.RECEITA)) {
			
			origem.setSaldo(origem.getSaldo() + dto.getValor());
			
		} else {
			
			origem.setSaldo(origem.getSaldo() - dto.getValor());
			
		}
		
		*/
/*
		 * Preenchendo o objeto transação
		 *//*

		
		transacao.setValorTransacao(dto.getValor());
		transacao.setPlanoContaTransacao(planoConta);
		transacao.setContaOrigemTransacao(origem);
		transacao.setDescricaoTransacao(dto.getDescricao());
		transacao.setDtLancamentoTransacao(dto.getDtLancamentoTransacao());
		
		*/
/*
		 * Se a transação for uma transferência, calculando o saldo final da conta destino e adicionando ao objeto a ser persistido.
		 *//*

		
		if(planoConta.getTpPlanoConta().equals(TipoPlanoContaEnum.TRANSFERENCIA)) {
			
			Conta destino = contaRepository.findbyDonoLogin(dto.getContaDestino());
			
			destino.setSaldo(destino.getSaldo() + dto.getValor());
			
			transacao.setContaDestino(destino);
			
		}
		
		return transacao;
		
	}

	private TransacaoDTO createFromModel(Transacao model) {
		
		TransacaoDTO dto = TransacaoDTO.builder()
				.contaDestino(model.getContaDestino().getDono().getLogin())
				.contaOrigemTransacao(model.getContaOrigemTransacao().getId())
				.descricao(model.getDescricaoTransacao())
				.dtLancamentoTransacao(model.getDtLancamentoTransacao())
				.login(model.getContaOrigemTransacao().getDono().getLogin())
				.planoConta(model.getPlanoContaTransacao().getIdPlanoConta())
				.valor(model.getValorTransacao())
				.build();
		
		return dto;
				
		
	}
	
}
*/
