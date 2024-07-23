package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.request.CategoryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CategoryResponseDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<CategoryResponseDto> create(CategoryRequestDto dto);
    Category getCategoryById(long id);

    ResponseEntity<List<CategoryResponseDto>> getAll();
    ResponseEntity<Void> deleteById(Long id);
}
