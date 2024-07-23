package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.request.CategoryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CategoryResponseDto;
import com.company.classworkrelationhomework.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryRequestDto dto){
          return categoryService.create(dto);
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAll(){
        return categoryService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        return categoryService.deleteById(id);
    }
}
