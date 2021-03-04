package com.bankline.bankline.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.dto.PlanoContaDTO;
import com.bankline.bankline.data.dto.PlanoContaFormDTO;
import com.bankline.bankline.data.exception.UsuarioNaoEncontradoException;
import com.bankline.bankline.data.model.PlanoConta;
import com.bankline.bankline.data.repository.PlanoContaRepository;

@Service
public class PlanoContaService {
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	
	public List<PlanoContaDTO> listaPlanoContaDisponiveis(String login) throws UsuarioNaoEncontradoException {
		
		List<PlanoConta> planos = planoContaRepository.findPlanoContaDisponiveis(usuarioService.buscar(login));
		
		return fromCreateDtoList(planos);
		
	}
	
	public PlanoContaDTO salvarPlanoConta(PlanoContaFormDTO planoConta) throws UsuarioNaoEncontradoException {
		
		PlanoConta pc = fromCreateDto(planoConta);
		
		return fromCreateDTO(planoContaRepository.save(pc));
		
	}
	
	private PlanoConta fromCreateDto(PlanoContaFormDTO planoConta) throws UsuarioNaoEncontradoException {
		
		PlanoConta pc = PlanoConta.builder()
								.descPlanoConta(planoConta.getDescricao())
								.isAtivoPlanoConta(planoConta.isAtivo())
								.isPadrao(planoConta.isPadrao())
								.tpPlanoConta(planoConta.getTipo())
								.usuarioCriador(usuarioService.buscar(planoConta.getLogin()))
								.idPlanoConta(planoConta.getId() == null ? null : planoConta.getId())
								.build();
		
		return pc;
		
	}

	private List<PlanoContaDTO> fromCreateDtoList(List<PlanoConta> planos) {
		
		List<PlanoContaDTO> dtos = new ArrayList<PlanoContaDTO>();
		
		for(PlanoConta plano : planos) {
			
			PlanoContaDTO dto = fromCreateDTO(plano);
			dtos.add(dto);
			
		}
		
		return dtos;
		
	}

	private PlanoContaDTO fromCreateDTO(PlanoConta plano) {
		
		PlanoContaDTO dto = PlanoContaDTO.builder()
							   .idPlanoConta(plano.getIdPlanoConta())
							   .isAtivoPlanoConta(plano.getIsAtivoPlanoConta())
							   .isPadrao(plano.getIsPadrao())
							   .descPlanoConta(plano.getDescPlanoConta())
							   .tpPlanoConta(plano.getTpPlanoConta())
							   .login(plano.getUsuarioCriador().getLogin())
							   .build();
		
		return dto;
	}

}
