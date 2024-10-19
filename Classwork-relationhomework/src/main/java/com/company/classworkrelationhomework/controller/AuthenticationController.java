package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.auth.request.LoginRequestDto;
import com.company.classworkrelationhomework.model.dto.auth.request.SignUpDto;
import com.company.classworkrelationhomework.model.dto.auth.response.LoginResponseDto;
import com.company.classworkrelationhomework.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authenticationService.login(dto));
    }
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refresh(@RequestParam("token") String refreshToken){
        return ResponseEntity.ok(authenticationService.refresh(refreshToken));
    }
    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody SignUpDto dto){
        return authenticationService.signUp(dto);
    }

    @PutMapping
    public ResponseEntity<Void> accessForApiKey(@RequestParam("id") Long id){
        authenticationService.accessForApiKey(id);
        return ResponseEntity.ok().build();
    }
}
