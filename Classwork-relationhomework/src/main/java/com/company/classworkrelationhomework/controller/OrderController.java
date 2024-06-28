package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.request.OrderRequestDto;
import com.company.classworkrelationhomework.model.dto.response.OrderResponseDto;
import com.company.classworkrelationhomework.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> create(@RequestBody List<OrderRequestDto> dto) {
        return orderService.create(dto);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAll() {
        return orderService.getAll();
    }
}
