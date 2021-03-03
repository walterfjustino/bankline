package com.bankline.bankline.data.model;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
@Builder
public class Credentials {

    @NotBlank
    String username;

    @NotBlank
    String password;

}
