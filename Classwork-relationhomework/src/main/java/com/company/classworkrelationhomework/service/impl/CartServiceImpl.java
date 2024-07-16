package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.CartMapper;
import com.company.classworkrelationhomework.model.dto.request.CartRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.entity.Cart;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.repository.CartRepository;
import com.company.classworkrelationhomework.service.CartService;
import com.company.classworkrelationhomework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CartMapper cartMapper;

    @Override
    public ResponseEntity<CartResponseDto> create(CartRequestDto dto) {
        Cart cart = cartRepository.save(Cart.builder().name(dto.getName()).build());
        return ResponseEntity.ok(new CartResponseDto(cart.getId(), cart.getName()));
    }

    @Override
    @Transactional
    public ResponseEntity<Void> addProduct(Long id, Long productId) {
        Cart cart = getCart(id);
        Product product = productService.getById(productId);
        cart.getProducts().add(product);
        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> delete(Long id, Long productId) {
        Cart cart = getCart(id);
        Product product = productService.getById(productId);
        cart.getProducts().remove(product);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CartResponseDto> get(Long id) {
        return ResponseEntity.ok(cartMapper.map(getCart(id)));
    }

    private Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("cart not found -> id: " + id));
    }
}
