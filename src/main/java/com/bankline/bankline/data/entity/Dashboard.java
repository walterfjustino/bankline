package com.bankline.bankline.data.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;



@Entity
@Table(name = "dashboard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dashboard {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "usuario")
    private Usuario usuario;

    @ElementCollection(targetClass=Transacao.class)
    private List<Transacao> transacoes;
}
