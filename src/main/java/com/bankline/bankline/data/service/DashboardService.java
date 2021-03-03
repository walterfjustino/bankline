package com.bankline.bankline.data.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.dto.DashboardDTO;
import com.bankline.bankline.data.dto.TransacaoDTO;
import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.exception.UsuarioNaoEncontradoException;
import com.bankline.bankline.data.model.Usuario;

@Service
public class DashboardService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TransacaoService transacaoService;
	
	// ******************************  Necessário Verificar ***************************************************
	
//	public DashboardDTO montar(Date dtInicial, Date dtFinal, String login) throws UsuarioNaoEncontradoException {
//		
//		Usuario usuario = usuarioService.buscar(login);
//		UsuarioDTO usuarioDto = usuarioService.fromCreateModel(usuario, false);
//		List<TransacaoDTO> transacoesDto = transacaoService.buscarPorIntervalo(usuario.getConta(), dtInicial, dtFinal);
//		
//		DashboardDTO dto = DashboardDTO.builder()
//				.usuario(usuarioDto)
//				.transacoes(transacoesDto)
//				.build();
//		
//		return dto;
//		
//	}

}
