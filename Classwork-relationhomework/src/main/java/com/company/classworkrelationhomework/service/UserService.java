package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.UserResponseDto;
import com.company.classworkrelationhomework.model.dto.request.UserRequestDto;

public interface UserService {
    UserResponseDto getById(Long id);
    UserResponseDto insert(UserRequestDto userRequestDto);
    UserResponseDto update(UserRequestDto userRequestDto,Long id);

    void delete(Long id);
}
