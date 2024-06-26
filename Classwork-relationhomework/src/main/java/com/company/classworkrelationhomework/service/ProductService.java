package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.request.ProductRequestDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    ResponseEntity<ProductResponseDto> create(ProductRequestDto dto);

    ResponseEntity<List<ProductResponseDto>> getAll();
}
