package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.UserMapper;
import com.company.classworkrelationhomework.model.dto.UserResponseDto;
import com.company.classworkrelationhomework.model.dto.request.UserRequestDto;
import com.company.classworkrelationhomework.model.entity.User;
import com.company.classworkrelationhomework.model.enums.ErrorCode;
import com.company.classworkrelationhomework.model.exception.NotFoundException;
import com.company.classworkrelationhomework.repository.UserRepository;
import com.company.classworkrelationhomework.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto getById(Long id) {
        User user = userRepository.findByName("Ali").get();
        System.err.println(user.getName());
        User user1 = userRepository.findById(id).get();
        System.err.println(user1.getName());
        return userMapper.map(user1);
    }

    @Override
    public UserResponseDto insert(UserRequestDto userRequestDto) {
        User user = userMapper.map(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.map(savedUser);
    }

    @Override
    @Transactional
    public UserResponseDto update(UserRequestDto userRequestDto, Long id) {
        User user = userRepository.findById(id).orElseThrow();
        User mappedUser = userMapper.map(userRequestDto, user);
        return userMapper.map(mappedUser);
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
    private User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new NotFoundException(ErrorCode.NOT_FOUND,id.toString()));
    }
}
