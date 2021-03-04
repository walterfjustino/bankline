package com.bankline.bankline.data.model;

import com.bankline.bankline.data.entity.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class ContaModel {


    private Long id;

    @NotBlank
    private Usuario dono;

    @NotNull
    private Double saldo;
}
