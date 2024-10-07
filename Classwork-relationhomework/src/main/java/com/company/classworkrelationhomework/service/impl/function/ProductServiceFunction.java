package com.company.classworkrelationhomework.service.impl.function;

import com.company.classworkrelationhomework.mapper.ProductMapper;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import com.company.classworkrelationhomework.repository.CompanyRepository;
import com.company.classworkrelationhomework.repository.OrderRepository;
import com.company.classworkrelationhomework.repository.ProductRepository;
import com.company.classworkrelationhomework.service.CategoryService;
import com.company.classworkrelationhomework.service.impl.ProductServiceImpl;
import com.company.classworkrelationhomework.specification.ProductSpecification;
import com.company.classworkrelationhomework.specification.RootSpecification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceFunction extends ProductServiceImpl {

    public ProductServiceFunction(ProductRepository productRepository, OrderRepository orderRepository, ProductMapper productMapper, CategoryService categoryService, ProductSpecification productSpecification, RootSpecification<Product> rootSpecification, CompanyRepository companyRepository) {
        super(productRepository, orderRepository, productMapper, categoryService, productSpecification, rootSpecification,companyRepository);
    }
    @Override
    public ResponseEntity<List<IncomeCalculation>> calculateIncome() {
        List<IncomeCalculation> incomeCalculations = orderRepository.calculateIncomeFunction();
        return ResponseEntity.ok(incomeCalculations);
    }
}
