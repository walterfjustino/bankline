package com.bankline.bankline.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "nome")
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "cpf")
    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "login")
    private String login;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "senha")
    private String senha;

    @Column(name = "loginTemp")
    private String senhaTemp;

    @Column(name = "is_redefinir_senha")
    private Boolean isRedefinirSenha;

    @Column(name = "dt_ultimo_login")
    private LocalDateTime dataUltimoLogin;

    @Column(name = "is_usuario_ativo")
    private Boolean isAtivo;


    @OneToOne(mappedBy = "dono", cascade = CascadeType.PERSIST)
    private Conta conta;

}