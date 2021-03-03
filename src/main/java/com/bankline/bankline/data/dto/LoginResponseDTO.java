package com.bankline.bankline.data.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LoginResponseDTO {

    String token;

}
