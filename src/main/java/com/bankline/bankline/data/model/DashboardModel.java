package com.bankline.bankline.data.model;

import com.bankline.bankline.data.entity.Transacao;
import com.bankline.bankline.data.entity.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@NoArgsConstructor
public class DashboardModel {

    @NotNull
    private Usuario usuario;

    private List<Transacao> transacoes;

}
