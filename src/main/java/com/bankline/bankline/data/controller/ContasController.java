package com.bankline.bankline.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.bankline.data.dto.PlanoContaDTO;
import com.bankline.bankline.data.dto.PlanoContaFormDTO;
import com.bankline.bankline.data.exception.UsuarioNaoEncontradoException;
import com.bankline.bankline.data.model.PlanoConta;
import com.bankline.bankline.data.model.Usuario;
import com.bankline.bankline.data.repository.PlanoContaRepository;
import com.bankline.bankline.data.service.PlanoContaService;

@RestController
@RequestMapping(value = "/api")
public class ContasController {
	
	@Autowired
	private PlanoContaService planoContaService;
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	
	@PostMapping("/novoPlanoConta")
	public ResponseEntity<?> novoPlanoConta(@RequestBody PlanoContaFormDTO planoConta) {
		
		try {	
			
			PlanoContaDTO dto = planoContaService.salvarPlanoConta(planoConta);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(dto);
			
		} catch (UsuarioNaoEncontradoException log) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(log.getMessage());
		}
		
	}
	
	@GetMapping("/listarPlanosConta")
	public ResponseEntity<List<PlanoConta>> listarPlanosConta(Usuario usuario){
		List<PlanoConta> listaPlanos = planoContaRepository.findPlanoContaDisponiveis(usuario);
		return ResponseEntity.status(HttpStatus.OK).body(listaPlanos);
	}

}
