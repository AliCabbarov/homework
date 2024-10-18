package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.config.BaseJwtService;
import com.company.classworkrelationhomework.model.dto.auth.request.LoginRequestDto;
import com.company.classworkrelationhomework.model.dto.auth.request.SignUpDto;
import com.company.classworkrelationhomework.model.dto.auth.response.LoginResponseDto;
import com.company.classworkrelationhomework.model.entity.User;
import com.company.classworkrelationhomework.model.enums.ErrorCode;
import com.company.classworkrelationhomework.model.enums.Roles;
import com.company.classworkrelationhomework.model.exception.BadRequestException;
import com.company.classworkrelationhomework.repository.UserRepository;
import com.company.classworkrelationhomework.service.AuthenticationService;
import com.company.classworkrelationhomework.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final BaseJwtService baseJwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        User user = getUserByEmail(dto.username(), dto.password());

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new BadRequestException(ErrorCode.INVALID_CREDENTIALS, dto.username(), dto.password());
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("authority", List.of(user.getRole().getRole().name()));
        claims.put("id", user.getId());
        claims.put("status", user.isEnabled());
        claims.put("name", user.getName());
        claims.put("surname", user.getSurname());

        String token = baseJwtService.generateToken(dto.username(),
                claims);
        return new LoginResponseDto(token, null);
    }

    @Override
    public ResponseEntity<Void> signUp(SignUpDto dto) {
        String password = dto.password();
        User user = User.builder().username(dto.username()).password(passwordEncoder.encode(password)).email(dto.username()).enabled(true).build();
        user.setRole(roleService.getUserRole());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    private User getUserByEmail(String email, String pass) {
        return userRepository.findByEmail(email).orElseThrow(() -> new BadRequestException(ErrorCode.INVALID_CREDENTIALS, email, pass));
    }

}
