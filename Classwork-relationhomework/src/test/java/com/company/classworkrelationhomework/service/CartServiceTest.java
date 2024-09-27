package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.mapper.CartMapper;
import com.company.classworkrelationhomework.model.dto.request.CartRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.entity.Cart;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.repository.CartRepository;
import com.company.classworkrelationhomework.service.impl.CartServiceImpl;
import com.company.classworkrelationhomework.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashSet;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    @InjectMocks
    @Spy
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
//        assertThat(verifiedCart.getId()).isEqualTo(savedcart.getId());
        assertThat(savedcart.getId()).isEqualTo(responseDto.getId());


        verify(cartMapper, times(1)).map(any(Cart.class));
        verify(redisTemplate.opsForValue(), times(1)).set(savedcart.getId(), cartResponseDto);


    }

    @Test
    public void addProductTest(){
        Long id = 5L;
        Long productId = 5L;

        Cart getCart = new Cart(id,"cart of name",new HashSet<>(),true);
        CartResponseDto cartResponseDto = new CartResponseDto(1L, "name of the cart");
        ValueOperations valueOperations = mock(ValueOperations.class);
        Product product = new Product();



        when(productService.getById(productId)).thenReturn(product);
        doReturn(getCart).when(cartService).getCart(id);
        when(cartRepository.save(any(Cart.class))).thenReturn(getCart);
        when(cartMapper.map(any(Cart.class))).thenReturn(cartResponseDto);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);


        CartResponseDto responseDto = cartService.addProduct(id, productId).getBody();

        assertThat(responseDto).isEqualTo(cartResponseDto);

    }

    @Test
    public  void delete(){
        Long id = 5L;

        Cart getCart = new Cart(id,"cart of name",new HashSet<>(),true);


        doReturn(getCart).when(cartService).getCart(id);
        doNothing().when(cartRepository).delete(getCart);
        doReturn(true).when(redisTemplate).delete(id);

        cartService.deleteCart(id).getBody();

        verify(cartRepository,times(1)).delete(getCart);


    }

    @Test
    public void getIfRedisNull(){
        Long id = 5L;

        CartResponseDto cartResponseDto = null;
        Cart getCart = new Cart(id,"cart of name",new HashSet<>(),true);
        CartResponseDto cartResponseDtoIsNotNull = new CartResponseDto(1L, "name of the cart");
        ValueOperations<Long, CartResponseDto> valueOperations = mock(ValueOperations.class);


        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get(id)).thenReturn(cartResponseDto);
        doReturn(getCart).when(cartService).getCart(id);
        when(cartMapper.map(any(Cart.class))).thenReturn(cartResponseDtoIsNotNull);


        CartResponseDto responseDto = cartService.get(id).getBody();


        assertThat(responseDto).isEqualTo(cartResponseDtoIsNotNull);
        verify(cartService,times(1)).getCart(any());
        verify(redisTemplate.opsForValue(), times(1)).get(id);
        verify(redisTemplate.opsForValue(), times(1)).set(id, cartResponseDtoIsNotNull);


    }
    @Test
    public void getIfRedisIsNotNull(){
        Long id = 5L;

        CartResponseDto cartResponseDtoIsNotNull = new CartResponseDto(1L, "name of the cart");
        ValueOperations<Long, CartResponseDto> valueOperations = mock(ValueOperations.class);


        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get(id)).thenReturn(cartResponseDtoIsNotNull);

        CartResponseDto responseDto = cartService.get(id).getBody();

        assertThat(responseDto).isEqualTo(cartResponseDtoIsNotNull);


    }
}
