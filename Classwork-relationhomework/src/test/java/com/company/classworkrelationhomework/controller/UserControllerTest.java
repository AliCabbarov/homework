package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.UserResponseDto;
import com.company.classworkrelationhomework.model.dto.request.UserRequestDto;
import com.company.classworkrelationhomework.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

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

    @Test
    void shouldCreateUser() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto("Ali","Jabbarov","jabbaroffali","123456");
        UserResponseDto userResponseDto = new UserResponseDto(1L,"Ali","Jabbarov","jabbaroffali");

        when(userService.insert(userRequestDto)).thenReturn(userResponseDto);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(jsonPath("$.name").value(userRequestDto.name()));
    }

    @Test
    void shouldUpdateUser() throws Exception{
        UserRequestDto userRequestDto = new UserRequestDto("Ali","Jabbarov","jabbaroffali","123456");
        UserResponseDto userResponseDto = new UserResponseDto(1L,"Ali","Jabbarov","jabbaroffali");
        Long id = 1L;

        when(userService.update(userRequestDto,id)).thenReturn(userResponseDto);

        mockMvc.perform(put("/users/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(jsonPath("$.name").value(userRequestDto.name()))
                .andExpect(jsonPath("$.surname").value(userRequestDto.surname()))
                .andExpect(jsonPath("$.username").value(userRequestDto.username()));
    }
}
