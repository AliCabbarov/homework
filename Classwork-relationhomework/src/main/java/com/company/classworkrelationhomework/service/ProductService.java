package com.company.classworkrelationhomework.service;

import com.company.classworkrelationhomework.model.dto.request.ProductRequestDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.dto.specification.SearchCriteria;
import com.company.classworkrelationhomework.model.dto.specification.product.ProductSpecificationDto;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ProductResponseDto create(ProductRequestDto dto);

    ResponseEntity<List<ProductResponseDto>> getAll();

    ResponseEntity<List<IncomeCalculation>> calculateIncome();
    Product getById(long id);
    ResponseEntity<List<ProductResponseDto>> productBySpecification(ProductSpecificationDto dto);
    ResponseEntity<List<ProductResponseDto>> searchByCriteria(List<SearchCriteria> dto);
    ProductResponseDto findById(Long id);
    ProductResponseDto delete(Long id);
}
