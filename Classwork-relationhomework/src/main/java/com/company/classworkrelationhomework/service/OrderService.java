package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.request.OrderRequestDto;
import com.company.classworkrelationhomework.model.dto.response.OrderReadResponseDto;
import com.company.classworkrelationhomework.model.dto.response.OrderResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface OrderService {
    ResponseEntity<OrderResponseDto> create(List<OrderRequestDto> dto);
    ResponseEntity<Collection<OrderResponseDto>> getAll();

    ResponseEntity<OrderReadResponseDto> getById(Long id);
}
