package com.bankline.bankline.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.dto.MessageResponseDTO;
import com.bankline.bankline.data.dto.PlanoContaDTO;
import com.bankline.bankline.data.exception.PlanoContaNotFoundException;
import com.bankline.bankline.data.mapper.PlanoContaMapper;
import com.bankline.bankline.data.model.PlanoConta;
import com.bankline.bankline.data.model.Transacao;
import com.bankline.bankline.data.repository.PlanoContaRepository;
import com.bankline.bankline.data.repository.TransacaoRepository;

@Service
public class PlanoContaService {
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	@Autowired
	private TransacaoRepository transacaoRepository;
	
//	private final PlanoContaMapper planoContaMapper = PlanoContaMapper.INSTANCE;
	
	
//	public PlanoContaService(PlanoContaRepository planoContaRepository, TransacaoRepository transacaoRepository) {
//		this.planoContaRepository = planoContaRepository;
//		this.transacaoRepository = transacaoRepository;
//	}
	
	//Metodo Post - cadastra Plano Conta
	
//	public MessageResponseDTO cadastroPlanoConta(PlanoContaDTO planoContaDTO) {
//		
//		PlanoConta planoContaToSalvar = planoContaMapper.toModel(planoContaDTO);
//		
//		PlanoConta planoContaSalva = planoContaRepository.save(planoContaToSalvar);
//		
//		return MessageResponseDTO.builder().message("Plano conta cadastrado ID: " + planoContaSalva.getIdPlanoConta()).build();
//		
//	} 
	
	//Metodo Get - pesquisa Plano Conta por id
	
//	public PlanoContaDTO pesquisaPlanoContaById(Long idPlanoConta) throws PlanoContaNotFoundException {
//		PlanoConta planoConta = planoContaRepository.findById(idPlanoConta)
//				.orElseThrow(() -> new PlanoContaNotFoundException(idPlanoConta));
//		return planoContaMapper.toDTO(planoConta);
//	}
	
	
	public List<PlanoConta> listaPlanoConta(){
	
		return planoContaRepository.findAll();
	}

	public List<Transacao> transacoesPlanoConta(){
		return transacaoRepository.findAll();
				
		
	}
}
