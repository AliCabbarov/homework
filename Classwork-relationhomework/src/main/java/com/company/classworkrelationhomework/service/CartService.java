package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.request.CartRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import org.springframework.http.ResponseEntity;

public interface CartService {
    ResponseEntity<CartResponseDto> create(CartRequestDto dto);

    ResponseEntity<Void> addProduct(Long id, Long productId);

    ResponseEntity<Void> delete(Long id, Long productId);

    ResponseEntity<CartResponseDto> get(Long id);
}
