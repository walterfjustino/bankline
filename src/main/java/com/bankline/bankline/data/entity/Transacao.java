package com.bankline.bankline.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "transacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_transacao")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_conta_origem_transacao")
    private Conta contaOrigemTransacao;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_plano_conta_transacao")
    private PlanoConta planoContaTransacao;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "dt_lancamento_transacao")
    private Date dtLancamentoTransacao;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "valor_transacao")
    private Double valorTransacao;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "descricao_transacao")
    private String descricaoTransacao;

    @ManyToOne
    @JoinColumn(name = "id_conta_destino")
    private Conta contaDestino;

    /*
     * Setada automaticamente ao instanciar o objeto
     */
    @CreationTimestamp
    @Column(name = "dt_criacao_transacao")
    private Date dtCadastroTransacao;

}
