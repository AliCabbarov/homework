package com.company.classworkrelationhomework.service.impl.cach;

import com.company.classworkrelationhomework.mapper.CartMapper;
import com.company.classworkrelationhomework.model.dto.request.CartRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.entity.Cart;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.repository.CartRepository;
import com.company.classworkrelationhomework.service.ProductService;
import com.company.classworkrelationhomework.service.impl.CartServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class CartServiceCacheImpl extends CartServiceImpl {

    private final CartRepository cartRepository;
    private final ProductService productService;
    private final CartMapper cartMapper;
    private final RedisTemplate<Long, Cart> redisTemplate;

    public CartServiceCacheImpl(CartRepository cartRepository, ProductService productService, CartMapper cartMapper, RedisTemplate<Long, CartResponseDto> redisTemplate, CartRepository cartRepository1, ProductService productService1, CartMapper cartMapper1, RedisTemplate<Long, Cart> redisTemplate1) {
        super(cartRepository, productService, cartMapper, redisTemplate);
        this.cartRepository = cartRepository1;
        this.productService = productService1;
        this.cartMapper = cartMapper1;
        this.redisTemplate = redisTemplate1;
    }

    @Override
    public ResponseEntity<CartResponseDto> create(CartRequestDto dto) {
        log.info("creating with cart cache service");

        Cart cart = cartRepository.save(Cart.builder().name(dto.getName()).products(new HashSet<>()).build());

        redisTemplate.opsForValue().set(cart.getId(), cart);

        return ResponseEntity.ok(cartMapper.map(cart));
    }

    @Override
    @Transactional
    public ResponseEntity<CartResponseDto> addProduct(Long id, Long productId) {
        log.info("adding with cart cache service");

        Cart cart = getCart(id);

        Product product = productService.getById(productId);

        cart.getProducts().add(product);

        redisTemplate.opsForValue().set(cart.getId(), cart);

        cartRepository.save(cart);

        return ResponseEntity.ok(cartMapper.map(cart));
    }

    @Override
    public ResponseEntity<Void> delete(Long id, Long productId) {
        log.info("deleting with cart cache service...");
        Cart cart = getCart(id);
        Product product = productService.getById(productId);
        cart.getProducts().remove(product);
        redisTemplate.opsForValue().set(id, cart);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CartResponseDto> get(Long id) {
        log.info("getting with cart cache service");

        Cart cart = redisTemplate.opsForValue().get(id);

        if (cart == null) {
            cart = getCart(id);
            redisTemplate.opsForValue().set(cart.getId(), cart, 1, TimeUnit.HOURS);
        }
        return ResponseEntity.ok(cartMapper.map(cart));
    }

    @Override
    public ResponseEntity<Void> deleteCart(Long id) {
        return null;
    }
}
