package com.bankline.bankline.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankline.bankline.data.dto.UsuarioAlterarSenhaDTO;
import com.bankline.bankline.data.dto.UsuarioDTO;
import com.bankline.bankline.data.dto.UsuarioNovaSenhaDTO;
import com.bankline.bankline.data.enums.RoleEnum;
import com.bankline.bankline.data.exception.UsuarioNaoEncontradoException;
import com.bankline.bankline.data.model.Usuario;
import com.bankline.bankline.data.model.UsuarioLogin;
import com.bankline.bankline.data.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ContaService contaService;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public Usuario cadastrar(UsuarioDTO usuarioDTO) {
		Usuario usuario = fromCreateDto(usuarioDTO);
		
		contaService.criar(usuario);
		
		return this.usuarioRepository.save(usuario);
	}

	public Usuario buscar(String login) throws UsuarioNaoEncontradoException {

		try {

			return usuarioRepository.findByLogin(login);

		} catch (NullPointerException e) {

			throw new UsuarioNaoEncontradoException();

		}

	}
	

	public UsuarioDTO alterarSenha(UsuarioAlterarSenhaDTO dto) throws UsuarioNaoEncontradoException {
		
		try {

			Usuario usuario = usuarioRepository.findByLogin(dto.getLogin());
			usuario.getUsuarioLogin().setSenha(this.passwordEncoder.encode(dto.getSenha()));
			return fromCreateModel(usuarioRepository.save(usuario), true);

		} catch (Exception e) {

			throw new UsuarioNaoEncontradoException();
		}
		
	}

	// nova senha
	public boolean solicitarNovaSenha(UsuarioNovaSenhaDTO dto) throws UsuarioNaoEncontradoException {
		try {

			Usuario usuario = usuarioRepository.findByLogin(dto.getLogin());
			usuario.getUsuarioLogin().setSenha(this.passwordEncoder.encode("12345"));
			usuario.setIsRedefinirSenha(true);
			return true;
		} catch (Exception e) {

			throw new UsuarioNaoEncontradoException();
		}
	}

	public Usuario fromCreateDto(UsuarioDTO usuarioDTO) {

		Usuario usuario = Usuario.builder().nome(usuarioDTO.getNome()).cpf(usuarioDTO.getCpf())
				.login(usuarioDTO.getLogin())
				.isRedefinirSenha(false)
				.dataUltimoLogin(null)
				.usuarioLogin(UsuarioLogin.builder().senha(this.passwordEncoder.encode(usuarioDTO.getSenha()))
						.username(usuarioDTO.getLogin()).role(RoleEnum.CLIENTE).build())
				.build();

		return usuario;

	}
	

	public UsuarioDTO fromCreateModel(Usuario model, boolean precisaSenha) {

		UsuarioDTO dto = UsuarioDTO.builder()
								.cpf(model.getCpf())
								.login(model.getLogin())
								.nome(model.getNome())
								.senha(precisaSenha ? model.getUsuarioLogin().getPassword() : null)
								.build();

		return dto;

	}
	
    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

}
