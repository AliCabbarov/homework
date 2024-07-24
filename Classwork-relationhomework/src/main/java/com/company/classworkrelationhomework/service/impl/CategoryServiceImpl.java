package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.CategoryMapper;
import com.company.classworkrelationhomework.model.dto.request.CategoryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CategoryResponseDto;
import com.company.classworkrelationhomework.model.entity.Category;
import com.company.classworkrelationhomework.repository.CategoryRepository;
import com.company.classworkrelationhomework.service.CategoryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final WeakReference<HashMap<Long,Category>> categoryCache = new WeakReference<>(new HashMap<>());


    @Override
    public ResponseEntity<CategoryResponseDto> create(CategoryRequestDto dto) {
        Category category = categoryMapper.map(dto);
        Category savedCategory = categoryRepository.save(category);

        addAndUpdateCache(savedCategory);

        return ResponseEntity.ok(categoryMapper.map(savedCategory));
    }

    @Override
    public Category getCategoryById(long id) {
        HashMap<Long, Category> longCategoryHashMap = categoryCache.get();

        if (longCategoryHashMap == null){
            longCategoryHashMap = new HashMap<>();
        }

        if (longCategoryHashMap.get(id) == null){

            Category category = categoryRepository.findById(id).orElseThrow(()
                    -> new RuntimeException("category not found -> id: " + id));

            addAndUpdateCache(category);

            return category;
        }
        return longCategoryHashMap.get(id);
    }

    @Override
    public ResponseEntity<List<CategoryResponseDto>> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtos = categoryMapper.map(categories);
        return ResponseEntity.ok(categoryResponseDtos);
    }

    public ResponseEntity<Void> deleteById(Long id){
        HashMap<Long, Category> longCategoryHashMap = categoryCache.get();
        if (longCategoryHashMap == null){
            longCategoryHashMap = new HashMap<>();
        }

        categoryRepository.deleteById(id);
        longCategoryHashMap.remove(id);

        return ResponseEntity.ok().build();
    }

    private void addAndUpdateCache(@NonNull Category category){
        HashMap<Long, Category> longCategoryHashMap = categoryCache.get();
        if (longCategoryHashMap == null){
            longCategoryHashMap = new HashMap<>();
        }
        longCategoryHashMap.put(category.getId(), category);
    }
}
