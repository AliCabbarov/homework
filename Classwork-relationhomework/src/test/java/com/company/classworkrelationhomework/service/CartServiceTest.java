package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.mapper.CartMapper;
import com.company.classworkrelationhomework.model.dto.request.CartRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.entity.Cart;
import com.company.classworkrelationhomework.repository.CartRepository;
import com.company.classworkrelationhomework.service.impl.CartServiceImpl;
import com.company.classworkrelationhomework.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    @InjectMocks
    CartServiceImpl cartService;
    @Mock
    CartRepository cartRepository;
    @Mock
    ProductServiceImpl productService;
    @Mock
    CartMapper cartMapper;
    @Mock
    RedisTemplate<Long, CartResponseDto> redisTemplate;

    @Test
//    @SuppressWarnings("all")
    public void create() {
        CartRequestDto cartRequestDto = new CartRequestDto("name of the cart");

        CartResponseDto cartResponseDto = new CartResponseDto(1L, "name of the cart");
        ValueOperations valueOperations = mock(ValueOperations.class);

        Cart savedcart = new Cart(1L, cartRequestDto.getName(), null, true);


        when(cartRepository.save(any(Cart.class))).thenReturn(savedcart);
        when(cartMapper.map(any(Cart.class))).thenReturn(cartResponseDto);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);

        CartResponseDto responseDto = cartService.create(cartRequestDto).getBody();

        var captor = ArgumentCaptor.forClass(Cart.class);
        verify(cartRepository, times(1)).save(captor.capture());

        Cart verifiedCart = captor.getValue();
        assertThat(verifiedCart.getId()).isEqualTo(savedcart.getId());
        assertThat(savedcart.getId()).isEqualTo(responseDto.getId());


        verify(cartMapper, times(1)).map(any(Cart.class));
        verify(redisTemplate.opsForValue(), times(1)).set(savedcart.getId(), cartResponseDto);


    }
}
