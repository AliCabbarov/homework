package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.UserResponseDto;
import com.company.classworkrelationhomework.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService; // Mock the service layer

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetUserById() throws Exception {
        UserResponseDto userResponseDto = new UserResponseDto(1L,"Ali","Jabbarov","jabbaroffali");
        when(userService.getById(1L)).thenReturn(userResponseDto);

        mockMvc.perform(get("/users/{id}",1L))
                .andExpect(jsonPath("$.name").value(userResponseDto.name()))
                .andExpect(jsonPath("$.username").value(userResponseDto.username()))
                .andExpect(jsonPath("$.surname").value(userResponseDto.surname()));

    }



}
