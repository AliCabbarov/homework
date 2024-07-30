package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.request.CartRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.dto.response.CategoryResponseDto;
import com.company.classworkrelationhomework.model.dto.response.ProductDetailResponseDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.service.CartService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {

    @Mock
    private CartService mockCartService;

    private CartController cartControllerUnderTest;

    @Test
    public void testAddProduct() {
        // Setup
        when(mockCartService.addProduct(0L, 0L)).thenReturn(new ResponseEntity<>(null, HttpStatus.OK));

        // Run the test
        final ResponseEntity<Void> result = cartControllerUnderTest.addProduct(0L, 0L);

        // Verify the results
    }

    @Test
    public void testCreate1() {
        // Setup
        final CartRequestDto dto = new CartRequestDto("name");

        // Configure CartService.create(...).
        final CartResponseDto cartResponseDto = new CartResponseDto();
        cartResponseDto.setId(0L);
        cartResponseDto.setName("name");
        cartResponseDto.setProducts(List.of(new ProductResponseDto(0L, "name", "description", new BigDecimal("0.00"), 0,
                new ProductDetailResponseDto(0L, "color", "imageUrl"), new CategoryResponseDto(0L, "name"))));
        final ResponseEntity<CartResponseDto> cartResponseDtoResponseEntity = new ResponseEntity<>(cartResponseDto,
                HttpStatus.OK);
        when(mockCartService.create(any(CartRequestDto.class))).thenReturn(cartResponseDtoResponseEntity);

        // Run the test
        final ResponseEntity<CartResponseDto> result = cartControllerUnderTest.create(dto);

        // Verify the results
    }

    @Test
    public void testDelete() {
        // Setup
        when(mockCartService.delete(0L, 0L)).thenReturn(new ResponseEntity<>(null, HttpStatus.OK));

        // Run the test
        final ResponseEntity<Void> result = cartControllerUnderTest.delete(0L, 0L);

        // Verify the results
    }

    @Test
    public void testGet() {
        // Setup
        // Configure CartService.get(...).
        final CartResponseDto cartResponseDto = new CartResponseDto();
        cartResponseDto.setId(0L);
        cartResponseDto.setName("name");
        cartResponseDto.setProducts(List.of(new ProductResponseDto(0L, "name", "description", new BigDecimal("0.00"), 0,
                new ProductDetailResponseDto(0L, "color", "imageUrl"), new CategoryResponseDto(0L, "name"))));
        final ResponseEntity<CartResponseDto> cartResponseDtoResponseEntity = new ResponseEntity<>(cartResponseDto,
                HttpStatus.OK);
        when(mockCartService.get(0L)).thenReturn(cartResponseDtoResponseEntity);

        // Run the test
        final ResponseEntity<CartResponseDto> result = cartControllerUnderTest.get(0L);

        // Verify the results
    }

    @Before
    public void setUp() {
        cartControllerUnderTest = new CartController(mockCartService);
    }

    @Test
    public void testCreate() {
        // Setup
        final CartRequestDto dto = new CartRequestDto("name");

        // Configure CartService.create(...).
        final CartResponseDto cartResponseDto = new CartResponseDto();
        cartResponseDto.setId(0L);
        cartResponseDto.setName("name");
        cartResponseDto.setProducts(List.of(new ProductResponseDto(0L, "name", "description", new BigDecimal("0.00"), 0,
                new ProductDetailResponseDto(0L, "color", "imageUrl"), new CategoryResponseDto(0L, "name"))));
        final ResponseEntity<CartResponseDto> cartResponseDtoResponseEntity = new ResponseEntity<>(cartResponseDto,
                HttpStatus.OK);
        when(mockCartService.create(any(CartRequestDto.class))).thenReturn(cartResponseDtoResponseEntity);

        // Run the test
        final ResponseEntity<CartResponseDto> result = cartControllerUnderTest.create(dto);

        // Verify the results
    }
}
