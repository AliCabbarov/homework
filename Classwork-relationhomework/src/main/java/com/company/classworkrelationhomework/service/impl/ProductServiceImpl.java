package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.ProductMapper;
import com.company.classworkrelationhomework.model.dto.request.ProductRequestDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.entity.Category;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import com.company.classworkrelationhomework.repository.ProductRepository;
import com.company.classworkrelationhomework.service.CategoryService;
import com.company.classworkrelationhomework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    @Override
    public ResponseEntity<ProductResponseDto> create(ProductRequestDto dto) {
        Product product = productMapper.map(dto);
        Category category = categoryService.getCategoryById(dto.getCategoryId());
        product.setCategory(category);
        Product saved = productRepository.save(product);
        return ResponseEntity.ok(productMapper.map(saved));
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = productMapper.map(products);
        return ResponseEntity.ok(productResponseDtos);
    }

    @Override
    public ResponseEntity<List<IncomeCalculation>> calculateIncome() {
        List<IncomeCalculation> incomeCalculations = productRepository.calculateIncome();
        return ResponseEntity.ok(incomeCalculations);
    }

    @Override
    public Product getById(long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("product not found -> id: " + id));
    }
}
