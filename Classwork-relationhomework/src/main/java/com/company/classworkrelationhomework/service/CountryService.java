package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.request.CountryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CountryResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CountryService {
    ResponseEntity<Void> create(CountryRequestDto dto);

    ResponseEntity<List<CountryResponseDto>> getAll();

    ResponseEntity<Void> delete(Long id);

    ResponseEntity<CountryResponseDto> findById(Long id);
}
