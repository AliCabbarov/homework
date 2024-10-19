package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.auth.request.LoginRequestDto;
import com.company.classworkrelationhomework.model.dto.auth.request.SignUpDto;
import com.company.classworkrelationhomework.model.dto.auth.response.LoginResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    LoginResponseDto login(LoginRequestDto dto);

    ResponseEntity<Void> signUp(SignUpDto dto);

    LoginResponseDto refresh(String refreshToken);

    void accessForApiKey(Long id);
}
