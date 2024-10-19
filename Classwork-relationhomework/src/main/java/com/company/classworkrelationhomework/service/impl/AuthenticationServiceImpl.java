package com.company.classworkrelationhomework.service.impl;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.company.classworkrelationhomework.config.BaseJwtService;
import com.company.classworkrelationhomework.model.dto.auth.request.LoginRequestDto;
import com.company.classworkrelationhomework.model.dto.auth.request.SignUpDto;
import com.company.classworkrelationhomework.model.dto.auth.response.LoginResponseDto;
import com.company.classworkrelationhomework.model.entity.User;
import com.company.classworkrelationhomework.model.enums.ErrorCode;
import com.company.classworkrelationhomework.model.enums.Roles;
import com.company.classworkrelationhomework.model.exception.BadRequestException;
import com.company.classworkrelationhomework.model.exception.NotFoundException;
import com.company.classworkrelationhomework.repository.UserRepository;
import com.company.classworkrelationhomework.service.AuthenticationService;
import com.company.classworkrelationhomework.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final BaseJwtService baseJwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    @Value("${application.token.refresh.time}")
    private Long refreshTokenTime;

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        User user = getUserByEmail(dto.username(), dto.password());

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new BadRequestException(ErrorCode.INVALID_CREDENTIALS, dto.username(), dto.password());
        }

        Map<String, Object> claims = buildClaims(user);
        String token = baseJwtService.generateToken(dto.username(), claims);

        String refreshToken = getRefreshToken();
        String apiKey = null;
        if (user.isHasApiKey()){
            apiKey =  getRefreshToken();
            user.setApiKey(apiKey);
        }
        user.setRefreshToken(refreshToken);
        user.setRefreshTokenExpiredDate(LocalDateTime.now().plusSeconds(refreshTokenTime));
        userRepository.save(user);

        return new LoginResponseDto(token, refreshToken,apiKey);
    }

    @Override
    public ResponseEntity<Void> signUp(SignUpDto dto) {
        String password = dto.password();
        User user = User.builder().username(dto.username()).password(passwordEncoder.encode(password)).email(dto.username()).enabled(true).build();
        user.setRole(roleService.getUserRole());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public LoginResponseDto refresh(String refreshToken) {
        User user = userRepository.findByRefreshTokenAndEnabled(refreshToken, true).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND, refreshToken));
        if (!refreshTokenTimeIsValid(user.getRefreshTokenExpiredDate())){
            throw new TokenExpiredException("Token expired", Instant.now());
        }

        Map<String, Object> claims = buildClaims(user);
        String token = baseJwtService.generateToken(user.getUsername(), claims);

        String newRefreshToken = getRefreshToken();
        user.setRefreshToken(newRefreshToken);
        String apiKey = null;
        if (user.isHasApiKey()){
            apiKey =  getRefreshToken();
            user.setApiKey(apiKey);
        }
        userRepository.save(user);
        return new LoginResponseDto(token, newRefreshToken,apiKey);
    }

    @Override
    public void accessForApiKey(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND, id.toString()));
        user.setHasApiKey(true);
        userRepository.save(user);
    }

    private User getUserByEmail(String email, String pass) {
        return userRepository.findByEmail(email).orElseThrow(() -> new BadRequestException(ErrorCode.INVALID_CREDENTIALS, email, pass));
    }

    private String getRefreshToken() {
        return UUID.randomUUID().toString();
    }

    private Map<String, Object> buildClaims(User user) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("authority", List.of(user.getRole().getRole().name()));
        claims.put("id", user.getId());
        claims.put("status", user.isEnabled());
        claims.put("name", user.getName());
        claims.put("surname", user.getSurname());
        return claims;
    }

    private boolean refreshTokenTimeIsValid(LocalDateTime time){
        return time.isAfter(LocalDateTime.now());
    };

}
