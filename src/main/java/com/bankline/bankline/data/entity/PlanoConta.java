package com.bankline.bankline.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.bankline.bankline.data.enums.TipoPlanoContaEnum;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.RequestMapping;


@Entity
@Table(name = "plano_conta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanoConta implements Serializable {
    private static final long serialVersionUID = 1L;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_plano_conta")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "descricao_plano_conta")
    private String descPlanoConta;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Enumerated(EnumType.STRING)
    @Column(name = "tp_plano_conta")
    private TipoPlanoContaEnum tpPlanoConta;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "is_ativo", nullable = false)
    private Boolean isAtivoPlanoConta;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ElementCollection(targetClass=Usuario.class)
    private Usuario usuarioCriado;

    @OneToMany(mappedBy = "planoContaTransacao", fetch = FetchType.LAZY)
    @ElementCollection(targetClass=Transacao.class)
    public List<Transacao> transacoesPlanoConta;

    @Column(name = "is_padrao", nullable = false)
    private Boolean isPadrao;

}
