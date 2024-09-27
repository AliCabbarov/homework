package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.UserResponseDto;
import com.company.classworkrelationhomework.model.dto.request.UserRequestDto;
import com.company.classworkrelationhomework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.insert(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto,@PathVariable Long id) {
        return ResponseEntity.ok(userService.update(dto,id));
    }
}
