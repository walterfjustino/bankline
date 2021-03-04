package com.bankline.bankline.data.service;

import java.util.ArrayList;
import java.util.List;

import com.bankline.bankline.data.entity.Usuario;
import com.bankline.bankline.data.exception.PlanoContaNotFoundException;
import com.bankline.bankline.data.model.PlanoContaModel;
import com.bankline.bankline.data.model.UsuarioModel;
import com.bankline.bankline.data.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bankline.bankline.data.exception.UsuarioNaoEncontradoException;
import com.bankline.bankline.data.entity.PlanoConta;
import com.bankline.bankline.data.repository.PlanoContaRepository;

@Service
public class PlanoContaService {

    @Autowired
    private PlanoContaRepository planoContaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    public PlanoContaService(PlanoContaRepository planoContaRepository, UsuarioRepository usuarioRepository) {
        this.planoContaRepository = planoContaRepository;
        this.usuarioRepository = usuarioRepository;

    }

    //CADASTRAR PLANO CONTA

    public Boolean cadastrarPlanoConta(PlanoContaModel planoContaModel) {
        PlanoConta planoConta = new PlanoConta();
        planoConta.setId(planoConta.getId());
        planoConta.setDescPlanoConta(planoConta.getDescPlanoConta());
        planoConta.setTpPlanoConta(planoConta.getTpPlanoConta());
        planoConta.setIsAtivoPlanoConta(planoConta.getIsAtivoPlanoConta());
        planoConta.setIsPadrao(planoConta.getIsPadrao());
        this.planoContaRepository.save(planoConta);
        return Boolean.TRUE;

    }


    //RETORNA LISTA COM TODOS PLANOS DE CONTA
    public List<PlanoConta> findAll() {

        return this.planoContaRepository.findAll();
    }

    //PESQUISA POR ID.
    public PlanoConta findById(Long id) throws PlanoContaNotFoundException {

        PlanoConta plano = this.planoContaRepository.findById(id).orElseThrow(() -> new PlanoContaNotFoundException(id));

        return plano;
    }

    //LISTA PLANO CONTA PELO USUARIO
    public List<PlanoConta> findPlanoContaDisponiveis(Usuario usuario) throws PlanoContaNotFoundException{

        List <PlanoConta> planoContaList = this.planoContaRepository.findPlanoContaDisponiveis(usuario);

        return planoContaList ;

    }


}

//Metodo Get - pesquisa Plano Conta por id

//	public PlanoContaDTO pesquisaPlanoContaById(Long idPlanoConta) throws PlanoContaNotFoundException {
//		PlanoConta planoConta = planoContaRepository.findById(idPlanoConta)
//				.orElseThrow(() -> new PlanoContaNotFoundException(idPlanoConta));
//		return planoContaMapper.toDTO(planoConta);
//	}
/*
	public List<PlanoContaDTO> listaPlanoContaDisponiveis(String login) throws UsuarioNaoEncontradoException {
		
		List<PlanoConta> planos = planoContaRepository.findPlanoContaDisponiveis(usuarioService.buscar(login));

		return fromCreateDtoList(planos);
		
	}
	
	public PlanoContaDTO salvarPlanoConta(PlanoContaDTO dto) throws UsuarioNaoEncontradoException {
		
		PlanoConta pc = fromCreateDto(dto);
		
		return fromCreateDTO(planoContaRepository.save(pc));
		
	}
	
	private PlanoConta fromCreateDto(PlanoContaDTO dto) throws UsuarioNaoEncontradoException {
		
		PlanoConta pc = PlanoConta.builder()
								.descPlanoConta(dto.getDescPlanoConta())
								.isAtivoPlanoConta(dto.getIsAtivoPlanoConta())
								.isPadrao(dto.getIsAtivoPlanoConta())
								.tpPlanoConta(dto.getTpPlanoConta())
								.usuarioCriador(usuarioService.buscar(dto.getLogin()))
								.idPlanoConta(dto.getIdPlanoConta() == null ? null : dto.getIdPlanoConta())
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
							   .transacoesPlanoConta(plano.getTransacoesPlanoConta())
							   .build();
		
		return dto;
	}*/


