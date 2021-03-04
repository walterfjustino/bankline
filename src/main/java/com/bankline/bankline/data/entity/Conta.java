package com.bankline.bankline.data.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "contas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_dono")
    private Usuario dono;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "conta_saldo", nullable = false)
    private Double saldo;


    @OneToMany(mappedBy = "contaOrigemTransacao", fetch = FetchType.LAZY)
    private List<Transacao> transacoes;

}
