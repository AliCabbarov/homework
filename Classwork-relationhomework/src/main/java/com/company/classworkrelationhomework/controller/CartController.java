package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.request.CartRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartResponseDto> create(@RequestBody CartRequestDto dto) {
        return cartService.create(dto);
    }

    @PostMapping("/{cartId}/product/{productId}")
    public ResponseEntity<Void> addProduct(@PathVariable Long cartId,
                                           @PathVariable Long productId) {
        cartService.addProduct(cartId,productId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{cartId}/product/{productId}")
    public ResponseEntity<Void> deleteFromCart(@PathVariable Long cartId,
                                       @PathVariable Long productId){
        return cartService.delete(cartId,productId);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CartResponseDto> get(@PathVariable Long id){
        return cartService.get(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return cartService.deleteCart(id);
    }
}
