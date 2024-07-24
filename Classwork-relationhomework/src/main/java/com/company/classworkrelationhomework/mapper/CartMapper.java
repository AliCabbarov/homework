package com.company.classworkrelationhomework.mapper;

import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@SuppressWarnings("all")
public interface CartMapper {
    CartResponseDto map(Cart cart);
}
