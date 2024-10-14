package com.company.classworkrelationhomework.mapper;

import com.company.classworkrelationhomework.model.dto.UserResponseDto;
import com.company.classworkrelationhomework.model.dto.request.UserRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.entity.Cart;
import com.company.classworkrelationhomework.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto map(User cart);
    @Mapping(target = "id",ignore = true)
    User map(UserRequestDto cart);
    @Mapping(target = "id",ignore = true)
    User map(UserRequestDto cart, @MappingTarget User user);
}
