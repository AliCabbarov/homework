package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.ProductMapper;
import com.company.classworkrelationhomework.model.dto.request.ProductRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CompanyResponse;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.dto.specification.SearchCriteria;
import com.company.classworkrelationhomework.model.dto.specification.product.ProductSpecificationDto;
import com.company.classworkrelationhomework.model.entity.Category;
import com.company.classworkrelationhomework.model.entity.Company;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.model.enums.ProductSort;
import com.company.classworkrelationhomework.model.exception.ApplicationException;
import com.company.classworkrelationhomework.model.exception.NotFoundException;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import com.company.classworkrelationhomework.repository.CompanyRepository;
import com.company.classworkrelationhomework.repository.OrderRepository;
import com.company.classworkrelationhomework.repository.ProductRepository;
import com.company.classworkrelationhomework.service.CategoryService;
import com.company.classworkrelationhomework.service.ProductService;
import com.company.classworkrelationhomework.specification.ProductSpecification;
import com.company.classworkrelationhomework.specification.RootSpecification;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.company.classworkrelationhomework.model.enums.ErrorCode.ALREADY_EXIST;
import static com.company.classworkrelationhomework.model.enums.ErrorCode.NOT_FOUND;


@RequiredArgsConstructor
@Service
@Primary
public class ProductServiceImpl implements ProductService {

    protected final ProductRepository productRepository;
    protected final OrderRepository orderRepository;
    protected final ProductMapper productMapper;
    protected final CategoryService categoryService;
    protected final ProductSpecification productSpecification;
    protected final RootSpecification<Product> rootSpecification;
    private final CompanyRepository companyRepository;

    @Override
    @CachePut(cacheNames = "products", key = "#result.id")
    public ProductResponseDto create(ProductRequestDto dto) {
        alreadyExistExceptionByName(dto.getName());
        Product product = productMapper.map(dto);
        Category category = categoryService.getCategoryById(dto.getCategoryId());
        product.setCategory(category);
        Product saved = productRepository.save(product);
        return productMapper.map(saved);
    }
    private void alreadyExistExceptionByName(@NonNull String name){
        boolean existsByName = productRepository.existsByName(name);
        if (existsByName){
            throw new ApplicationException(ALREADY_EXIST,name);
        }
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
                new NotFoundException(NOT_FOUND,String.valueOf(id)));
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
    @Cacheable(cacheNames = "products", key = "#id")
    public ProductResponseDto findById(Long id) {
        return productMapper.map(getById(id));
    }

    @Override
    @CacheEvict(cacheNames = "products", key = "#id")
    public ProductResponseDto delete(Long id) {
        Product product = getById(id);
        productRepository.delete(product);
        return productMapper.map(product);
    }

    @Override
    public ResponseEntity<CompanyResponse> totalIncome() {
        Company company = companyRepository.findByName("jabbaroff");
        CompanyResponse companyResponse = new CompanyResponse(company.getId(), company.getName(),company.getTotalAmount());
        return ResponseEntity.ok(companyResponse);
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
