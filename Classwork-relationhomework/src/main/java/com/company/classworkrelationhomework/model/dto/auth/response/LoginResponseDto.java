package com.company.classworkrelationhomework.model.dto.auth.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LoginResponseDto(String accessToken,String refreshToken,String apiKey) {
}
