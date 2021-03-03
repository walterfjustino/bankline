package com.bankline.bankline.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.exception.UsuarioNaoEncontradoException;
import com.bankline.bankline.data.model.Conta;
import com.bankline.bankline.data.model.Usuario;
import com.bankline.bankline.data.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

//	@Autowired
//	private ContaService contaService;

//	@Autowired
//	private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

	public Usuario cadastrar(UsuarioDTO usuarioDTO) {
		Usuario usuario = fromCreateDto(usuarioDTO);
		return this.usuarioRepository.save(usuario);
	}
	
	public Usuario buscar(String login) throws UsuarioNaoEncontradoException {
		
		try {
			
			return usuarioRepository.findByLogin(login);
			
		} catch (NullPointerException e) {
			
			throw new UsuarioNaoEncontradoException();
			
		}
		
	}
	
	// alterar senha 
	public Usuario alterarSenha(String login, String senha) throws UsuarioNaoEncontradoException {
		try {
			
			Usuario usuario = usuarioRepository.findByLogin(login);
			usuario.setSenha(senha);
			return this.usuarioRepository.save(usuario);
					
		} catch (Exception e) {
			
			throw new UsuarioNaoEncontradoException();
		}
	}
	
	// nova senha
	public Usuario solicitarNovaSenha(String login, String senhaTemp) throws UsuarioNaoEncontradoException {
		try {
			
			Usuario usuario = usuarioRepository.findByLogin(login);
			usuario.setSenhaTemp(senhaTemp);
			usuario.setIsRedefinirSenha(true);
			return this.usuarioRepository.save(usuario);
					
		} catch (Exception e) {
			
			throw new UsuarioNaoEncontradoException();
		}
	}
	
	// Metodo Post - cadastrar usuario
//	public MessageResponseDTO cadastrar(UsuarioDTO usuarioDTO) {
//		
//		Usuario usuarioToSalvar = usuarioMapper.toModel(usuarioDTO);
//		
//		Usuario usuarioSalvo = usuarioRepository.save(usuarioToSalvar);
//		return MessageResponseDTO.builder().message("Usuário cadastrado ID: " + usuarioSalvo.getIdUsuario()).build();
//			
//	}

	public Usuario fromCreateDto(UsuarioDTO usuarioDTO) {

		Usuario usuario = Usuario.builder()
					.nome(usuarioDTO.getNome())
					.cpf(usuarioDTO.getCpf())
					.login(usuarioDTO.getLogin())
					.senha(usuarioDTO.getSenha())
					.senhaTemp(null)
					.conta(Conta.builder().saldo(0.0).build())
					.isRedefinirSenha(false)
					.dataUltimoLogin(null)
					.build();

		//contaService.criar(usuario);

		return usuario;

	}
	
	public UsuarioDTO fromCreateModel(Usuario model, boolean precisaSenha) {
		
		UsuarioDTO dto = UsuarioDTO.builder()
				.cpf(model.getCpf())
				.login(model.getLogin())
				.nome(model.getNome())
				.senha(precisaSenha ? model.getSenha() : null)
				.build();
		
		return dto;
		
	}

}
