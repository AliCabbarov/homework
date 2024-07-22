package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.ProductMapper;
import com.company.classworkrelationhomework.model.dto.request.ProductRequestDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.dto.specification.SearchCriteria;
import com.company.classworkrelationhomework.model.dto.specification.product.ProductSpecificationDto;
import com.company.classworkrelationhomework.model.entity.Category;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.model.enums.ProductSort;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import com.company.classworkrelationhomework.repository.OrderRepository;
import com.company.classworkrelationhomework.repository.ProductRepository;
import com.company.classworkrelationhomework.service.CategoryService;
import com.company.classworkrelationhomework.service.ProductService;
import com.company.classworkrelationhomework.specification.ProductSpecification;
import com.company.classworkrelationhomework.specification.RootSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    private final ProductSpecification productSpecification;
    private final RootSpecification<Product> rootSpecification;

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
        List<Product> products = productRepository.findAll(Sort.by("id").ascending());
        List<ProductResponseDto> productResponseDtos = productMapper.map(products);
        return ResponseEntity.ok(productResponseDtos);
    }

    @Override
    public ResponseEntity<List<IncomeCalculation>> calculateIncome() {
        List<IncomeCalculation> incomeCalculations = orderRepository.calculateIncome();
        return ResponseEntity.ok(incomeCalculations);
    }

    @Override
    public Product getById(long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("product not found -> id: " + id));
    }

    public ResponseEntity<List<ProductResponseDto>> productBySpecification(ProductSpecificationDto dto) {
        Specification<Product> specification;
        if (dto != null) specification = productSpecification.hasName(dto.getName())
                .and(productSpecification.greaterThanPrice(dto.getInitialPrice()))
                .and(productSpecification.lessThanPrice(dto.getSecondPrice()))
                .and(productSpecification
                        .sorted(dto.getProductSort() == null ? ProductSort.ID : dto.getProductSort(), dto.getIsAsc() != null ? dto.getIsAsc() : true));

        else specification = productSpecification.sorted(ProductSort.ID, true);


        List<ProductResponseDto> response = productRepository.findAll(specification).stream()
                .map(productMapper::map)
                .toList();

        return ResponseEntity.ok(response);
    }

    @Override
    public ProductResponseDto findById(Long id) {
        return productMapper.map(getById(id));
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> searchByCriteria(List<SearchCriteria> dto) {
        for (SearchCriteria searchCriteria : dto) {
            rootSpecification.add(searchCriteria);
        }
        List<ProductResponseDto> response = productRepository.findAll(rootSpecification).stream()
                .map(productMapper::map)
                .toList();
        return ResponseEntity.ok(response);
    }
}
