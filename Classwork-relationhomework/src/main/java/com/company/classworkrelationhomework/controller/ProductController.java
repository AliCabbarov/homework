package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.request.ProductRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CompanyResponse;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.dto.specification.SearchCriteria;
import com.company.classworkrelationhomework.model.dto.specification.product.ProductSpecificationDto;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import com.company.classworkrelationhomework.service.ProductService;
import com.company.classworkrelationhomework.service.impl.function.ProductServiceFunction;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductServiceFunction productServiceFunction;

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody @Valid ProductRequestDto dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/income")
    public ResponseEntity<List<IncomeCalculation>> incomeCalculate() {
        return productServiceFunction.calculateIncome();
    }
    @GetMapping("/total-income")
    public ResponseEntity<CompanyResponse> totalIncomeCalculate() {
        return productServiceFunction.totalIncome();
    }

    @RequestMapping(value = "/specification", method = RequestMethod.GET)
    public ResponseEntity<List<ProductResponseDto>> productBySpecification(@ModelAttribute() ProductSpecificationDto dto) {
        return productService.productBySpecification(dto);
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDto>> criteriaSearch(@RequestBody List<SearchCriteria> criteria){
        return productService.searchByCriteria(criteria);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> criteriaSearch(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
