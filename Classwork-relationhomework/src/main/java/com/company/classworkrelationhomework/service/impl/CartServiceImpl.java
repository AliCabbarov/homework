package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.CartMapper;
import com.company.classworkrelationhomework.mapper.ProductMapper;
import com.company.classworkrelationhomework.model.dto.request.CartRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.entity.Cart;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.repository.CartRepository;
import com.company.classworkrelationhomework.service.CartService;
import com.company.classworkrelationhomework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;


@Service
@RequiredArgsConstructor
@Primary
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CartMapper cartMapper;
    private final RedisTemplate<Long, CartResponseDto> redisTemplate;

    @Override
    public ResponseEntity<CartResponseDto> create(CartRequestDto dto) {
        Cart cart = cartRepository.save(Cart.builder().name(dto.getName()).products(new HashSet<>()).build());

        CartResponseDto cartResponseDto = cartMapper.map(cart);

        redisTemplate.opsForValue().set(cart.getId(), cartResponseDto);

        return ResponseEntity.ok(cartResponseDto);
    }

    @Override
    public ResponseEntity<CartResponseDto> addProduct(Long id, Long productId) {
        Cart cart = getCart(id);
        Product product = productService.getById(productId);
        cart.getProducts().add(product);

        Cart savedCart = cartRepository.save(cart);

        CartResponseDto map = cartMapper.map(savedCart);

        redisTemplate.opsForValue().set(cart.getId(), map);

        return ResponseEntity.ok(map);
    }

    @Override
    @Transactional
    public ResponseEntity<Void> delete(Long id, Long productId) {
        Cart cart = getCart(id);
        Product product = productService.getById(productId);
        cart.getProducts().remove(product);

        CartResponseDto cartResponseDto = cartMapper.map(cart);
        redisTemplate.opsForValue().set(cart.getId(),cartResponseDto);

        return ResponseEntity.ok().build();
    }

    @Override
    @Transactional
    public ResponseEntity<CartResponseDto> get(Long id) {
        CartResponseDto responseDto = redisTemplate.opsForValue().get(id);
        if (responseDto == null) {
            Cart cart = getCart(id);
            responseDto = cartMapper.map(cart);
            redisTemplate.opsForValue().set(id, responseDto);
        }
        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<Void> deleteCart(Long id) {
        Cart cart = getCart(id);
        cartRepository.delete(cart);
        redisTemplate.delete(id);
        return ResponseEntity.ok().build();
    }

    protected Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("cart not found -> id: " + id));
    }
}
