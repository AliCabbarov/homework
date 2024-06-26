package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.CategoryMapper;
import com.company.classworkrelationhomework.model.dto.request.CategoryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CategoryResponseDto;
import com.company.classworkrelationhomework.model.entity.Category;
import com.company.classworkrelationhomework.repository.CategoryRepository;
import com.company.classworkrelationhomework.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<CategoryResponseDto> create(CategoryRequestDto dto) {
        Category category = categoryMapper.map(dto);
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(categoryMapper.map(savedCategory));
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("category not found -> id: " + id));
    }

    @Override
    public ResponseEntity<List<CategoryResponseDto>> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtos = categoryMapper.map(categories);
        return ResponseEntity.ok(categoryResponseDtos);
    }
}
