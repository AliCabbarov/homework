package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.request.CartRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.entity.Cart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {
    ResponseEntity<CartResponseDto> create(CartRequestDto dto);

    ResponseEntity<CartResponseDto> addProduct(Long id, Long productId);

    ResponseEntity<Void> delete(Long id, Long productId);

    ResponseEntity<CartResponseDto> get(Long id);

    ResponseEntity<Void> deleteCart(Long id);
}
