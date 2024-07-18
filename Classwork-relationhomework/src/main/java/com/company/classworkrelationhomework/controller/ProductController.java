package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.request.ProductRequestDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.dto.specification.ProductSpecificationDto;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import com.company.classworkrelationhomework.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto dto) {
        return productService.create(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/income")
    public ResponseEntity<List<IncomeCalculation>> incomeCalculate() {
        return productService.calculateIncome();
    }

    @RequestMapping(value = "/specification", method = RequestMethod.GET)
    public ResponseEntity<List<ProductResponseDto>> productBySpecification(@ModelAttribute ProductSpecificationDto dto) {
        return productService.productBySpecification(dto);
    }
}
