package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.config.JwtCredentials;
import com.company.classworkrelationhomework.model.dto.UserResponseDto;
import com.company.classworkrelationhomework.model.dto.request.UserRequestDto;
import com.company.classworkrelationhomework.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<String> get() {
        JwtCredentials jwtCredentials = (JwtCredentials) SecurityContextHolder.getContext().getAuthentication().getDetails();
        log.info("jwt credentials details is here {}", jwtCredentials);
        return ResponseEntity.ok("hello user");
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto, @PathVariable Long id) {
        return ResponseEntity.ok(userService.update(dto, id));
    }
}
