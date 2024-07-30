package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.ProductMapper;
import com.company.classworkrelationhomework.model.dto.request.ProductDetailRequestDto;
import com.company.classworkrelationhomework.model.dto.request.ProductRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CategoryResponseDto;
import com.company.classworkrelationhomework.model.dto.response.ProductDetailResponseDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.dto.specification.SearchCriteria;
import com.company.classworkrelationhomework.model.dto.specification.product.ProductSpecificationDto;
import com.company.classworkrelationhomework.model.entity.Category;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.model.enums.ProductSort;
import com.company.classworkrelationhomework.model.enums.SearchOperation;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import com.company.classworkrelationhomework.repository.OrderRepository;
import com.company.classworkrelationhomework.repository.ProductRepository;
import com.company.classworkrelationhomework.service.CategoryService;
import com.company.classworkrelationhomework.specification.ProductSpecification;
import com.company.classworkrelationhomework.specification.RootSpecification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository mockProductRepository;
    @Mock
    private OrderRepository mockOrderRepository;
    @Mock
    private ProductMapper mockProductMapper;
    @Mock
    private CategoryService mockCategoryService;
    @Mock
    private ProductSpecification mockProductSpecification;
    @Mock
    private RootSpecification<Product> mockRootSpecification;

    private ProductServiceImpl productServiceImplUnderTest;

    @Before
    public void setUp() {
        productServiceImplUnderTest = new ProductServiceImpl(mockProductRepository, mockOrderRepository,
                mockProductMapper, mockCategoryService, mockProductSpecification, mockRootSpecification);
    }

    @Test
    public void testCreate() {
        // Setup
        final ProductRequestDto dto = new ProductRequestDto("name", "description", new BigDecimal("0.00"), 0,
                new ProductDetailRequestDto("color", "imageUrl"), 0L);

        // Configure ProductMapper.map(...).
        final Product product = new Product();
        product.setId(0L);
        product.setName("name");
        product.setDescription("description");
        product.setPrice(new BigDecimal("0.00"));
        final Category category = new Category();
        product.setCategory(category);
        when(mockProductMapper.map(any(ProductRequestDto.class))).thenReturn(product);

        // Configure CategoryService.getCategoryById(...).
        final Category category1 = new Category();
        category1.setId(0L);
        category1.setName("name");
        when(mockCategoryService.getCategoryById(0L)).thenReturn(category1);

        // Configure ProductRepository.save(...).
        final Product product1 = new Product();
        product1.setId(0L);
        product1.setName("name");
        product1.setDescription("description");
        product1.setPrice(new BigDecimal("0.00"));
        final Category category2 = new Category();
        product1.setCategory(category2);
        when(mockProductRepository.save(any(Product.class))).thenReturn(product1);

        // Configure ProductMapper.map(...).
        final ProductResponseDto productResponseDto = new ProductResponseDto(0L, "name", "description",
                new BigDecimal("0.00"), 0, new ProductDetailResponseDto(0L, "color", "imageUrl"),
                new CategoryResponseDto(0L, "name"));
        when(mockProductMapper.map(any(Product.class))).thenReturn(productResponseDto);

        // Run the test
        final ResponseEntity<ProductResponseDto> result = productServiceImplUnderTest.create(dto);

        // Verify the results
    }

    @Test
    public void testCreate_ProductRepositoryThrowsOptimisticLockingFailureException() {
        // Setup
        final ProductRequestDto dto = new ProductRequestDto("name", "description", new BigDecimal("0.00"), 0,
                new ProductDetailRequestDto("color", "imageUrl"), 0L);

        // Configure ProductMapper.map(...).
        final Product product = new Product();
        product.setId(0L);
        product.setName("name");
        product.setDescription("description");
        product.setPrice(new BigDecimal("0.00"));
        final Category category = new Category();
        product.setCategory(category);
        when(mockProductMapper.map(any(ProductRequestDto.class))).thenReturn(product);

        // Configure CategoryService.getCategoryById(...).
        final Category category1 = new Category();
        category1.setId(0L);
        category1.setName("name");
        when(mockCategoryService.getCategoryById(0L)).thenReturn(category1);

        when(mockProductRepository.save(any(Product.class))).thenThrow(OptimisticLockingFailureException.class);

        // Run the test
        assertThrows(OptimisticLockingFailureException.class, () -> productServiceImplUnderTest.create(dto));
    }

    @Test
    public void testGetAll() {
        // Setup
        // Configure ProductRepository.findAll(...).
        final Product product = new Product();
        product.setId(0L);
        product.setName("name");
        product.setDescription("description");
        product.setPrice(new BigDecimal("0.00"));
        final Category category = new Category();
        product.setCategory(category);
        final List<Product> products = List.of(product);
        when(mockProductRepository.findAll(Sort.by("properties"))).thenReturn(products);

        // Configure ProductMapper.map(...).
        final List<ProductResponseDto> productResponseDtos = List.of(
                new ProductResponseDto(0L, "name", "description", new BigDecimal("0.00"), 0,
                        new ProductDetailResponseDto(0L, "color", "imageUrl"), new CategoryResponseDto(0L, "name")));
        final Product product2 = new Product();
        product2.setId(0L);
        product2.setName("name");
        product2.setDescription("description");
        product2.setPrice(new BigDecimal("0.00"));
        final Category category1 = new Category();
        product2.setCategory(category1);
        final List<Product> product1 = List.of(product2);
        when(mockProductMapper.map(product1)).thenReturn(productResponseDtos);

        // Run the test
        final ResponseEntity<List<ProductResponseDto>> result = productServiceImplUnderTest.getAll();

        // Verify the results
    }

    @Test
    public void testGetAll_ProductRepositoryReturnsNoItems() {
        // Setup
        when(mockProductRepository.findAll(Sort.by("properties"))).thenReturn(Collections.emptyList());

        // Configure ProductMapper.map(...).
        final List<ProductResponseDto> productResponseDtos = List.of(
                new ProductResponseDto(0L, "name", "description", new BigDecimal("0.00"), 0,
                        new ProductDetailResponseDto(0L, "color", "imageUrl"), new CategoryResponseDto(0L, "name")));
        final Product product1 = new Product();
        product1.setId(0L);
        product1.setName("name");
        product1.setDescription("description");
        product1.setPrice(new BigDecimal("0.00"));
        final Category category = new Category();
        product1.setCategory(category);
        final List<Product> product = List.of(product1);
        when(mockProductMapper.map(product)).thenReturn(productResponseDtos);

        // Run the test
        final ResponseEntity<List<ProductResponseDto>> result = productServiceImplUnderTest.getAll();

        // Verify the results
        assertEquals(ResponseEntity.ok(Collections.emptyList()), result);
    }

    @Test
    public void testGetAll_ProductMapperReturnsNoItems() {
        // Setup
        // Configure ProductRepository.findAll(...).
        final Product product = new Product();
        product.setId(0L);
        product.setName("name");
        product.setDescription("description");
        product.setPrice(new BigDecimal("0.00"));
        final Category category = new Category();
        product.setCategory(category);
        final List<Product> products = List.of(product);
        when(mockProductRepository.findAll(Sort.by("properties"))).thenReturn(products);

        // Configure ProductMapper.map(...).
        final Product product2 = new Product();
        product2.setId(0L);
        product2.setName("name");
        product2.setDescription("description");
        product2.setPrice(new BigDecimal("0.00"));
        final Category category1 = new Category();
        product2.setCategory(category1);
        final List<Product> product1 = List.of(product2);
        when(mockProductMapper.map(product1)).thenReturn(Collections.emptyList());

        // Run the test
        final ResponseEntity<List<ProductResponseDto>> result = productServiceImplUnderTest.getAll();

        // Verify the results
    }

    @Test
    public void testCalculateIncome() {
        // Setup
        when(mockOrderRepository.calculateIncome()).thenReturn(List.of());

        // Run the test
        final ResponseEntity<List<IncomeCalculation>> result = productServiceImplUnderTest.calculateIncome();

        // Verify the results
    }

    @Test
    public void testCalculateIncome_OrderRepositoryReturnsNoItems() {
        // Setup
        when(mockOrderRepository.calculateIncome()).thenReturn(Collections.emptyList());

        // Run the test
        final ResponseEntity<List<IncomeCalculation>> result = productServiceImplUnderTest.calculateIncome();

        // Verify the results
        assertEquals(ResponseEntity.ok(Collections.emptyList()), result);
    }

    @Test
    public void testGetById() {
        // Setup
        // Configure ProductRepository.findById(...).
        final Product product1 = new Product();
        product1.setId(0L);
        product1.setName("name");
        product1.setDescription("description");
        product1.setPrice(new BigDecimal("0.00"));
        final Category category = new Category();
        product1.setCategory(category);
        final Optional<Product> product = Optional.of(product1);
        when(mockProductRepository.findById(0L)).thenReturn(product);

        // Run the test
        final Product result = productServiceImplUnderTest.getById(0L);

        // Verify the results
    }

    @Test
    public void testGetById_ProductRepositoryReturnsAbsent() {
        // Setup
        when(mockProductRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThrows(RuntimeException.class, () -> productServiceImplUnderTest.getById(0L));
    }

    @Test
    public void testProductBySpecification() {
        // Setup
        final ProductSpecificationDto dto = new ProductSpecificationDto();
        dto.setName("name");
        dto.setInitialPrice(new BigDecimal("0.00"));
        dto.setSecondPrice(new BigDecimal("0.00"));
        dto.setProductSort(ProductSort.NAME);
        dto.setIsAsc(false);

        // Configure ProductSpecification.hasName(...).
        final Specification<Product> specification = Specification.allOf(List.of(Specification.allOf(List.of())));
        when(mockProductSpecification.hasName("name")).thenReturn(specification);

        // Configure ProductSpecification.greaterThanPrice(...).
        final Specification<Product> specification1 = Specification.allOf(List.of(Specification.allOf(List.of())));
        when(mockProductSpecification.greaterThanPrice(new BigDecimal("0.00"))).thenReturn(specification1);

        // Configure ProductSpecification.lessThanPrice(...).
        final Specification<Product> specification2 = Specification.allOf(List.of(Specification.allOf(List.of())));
        when(mockProductSpecification.lessThanPrice(new BigDecimal("0.00"))).thenReturn(specification2);

        // Configure ProductSpecification.sorted(...).
        final Specification<Product> specification3 = Specification.allOf(List.of(Specification.allOf(List.of())));
        when(mockProductSpecification.sorted(ProductSort.NAME, false)).thenReturn(specification3);

        // Configure ProductRepository.findAll(...).
        final Product product = new Product();
        product.setId(0L);
        product.setName("name");
        product.setDescription("description");
        product.setPrice(new BigDecimal("0.00"));
        final Category category = new Category();
        product.setCategory(category);
        final List<Product> products = List.of(product);
        when(mockProductRepository.findAll(any(Specification.class))).thenReturn(products);

        // Configure ProductMapper.map(...).
        final ProductResponseDto productResponseDto = new ProductResponseDto(0L, "name", "description",
                new BigDecimal("0.00"), 0, new ProductDetailResponseDto(0L, "color", "imageUrl"),
                new CategoryResponseDto(0L, "name"));
        when(mockProductMapper.map(any(Product.class))).thenReturn(productResponseDto);

        // Run the test
        final ResponseEntity<List<ProductResponseDto>> result = productServiceImplUnderTest.productBySpecification(dto);

        // Verify the results
    }

    @Test
    public void testProductBySpecification_ProductRepositoryReturnsNoItems() {
        // Setup
        final ProductSpecificationDto dto = new ProductSpecificationDto();
        dto.setName("name");
        dto.setInitialPrice(new BigDecimal("0.00"));
        dto.setSecondPrice(new BigDecimal("0.00"));
        dto.setProductSort(ProductSort.NAME);
        dto.setIsAsc(false);

        // Configure ProductSpecification.hasName(...).
        final Specification<Product> specification = Specification.allOf(List.of(Specification.allOf(List.of())));
        when(mockProductSpecification.hasName("name")).thenReturn(specification);

        // Configure ProductSpecification.greaterThanPrice(...).
        final Specification<Product> specification1 = Specification.allOf(List.of(Specification.allOf(List.of())));
        when(mockProductSpecification.greaterThanPrice(new BigDecimal("0.00"))).thenReturn(specification1);

        // Configure ProductSpecification.lessThanPrice(...).
        final Specification<Product> specification2 = Specification.allOf(List.of(Specification.allOf(List.of())));
        when(mockProductSpecification.lessThanPrice(new BigDecimal("0.00"))).thenReturn(specification2);

        // Configure ProductSpecification.sorted(...).
        final Specification<Product> specification3 = Specification.allOf(List.of(Specification.allOf(List.of())));
        when(mockProductSpecification.sorted(ProductSort.NAME, false)).thenReturn(specification3);

        when(mockProductRepository.findAll(any(Specification.class))).thenReturn(Collections.emptyList());

        // Run the test
        final ResponseEntity<List<ProductResponseDto>> result = productServiceImplUnderTest.productBySpecification(dto);

        // Verify the results
        assertEquals(ResponseEntity.ok(Collections.emptyList()), result);
    }

    @Test
    public void testFindById() {
        // Setup
        // Configure ProductRepository.findById(...).
        final Product product1 = new Product();
        product1.setId(0L);
        product1.setName("name");
        product1.setDescription("description");
        product1.setPrice(new BigDecimal("0.00"));
        final Category category = new Category();
        product1.setCategory(category);
        final Optional<Product> product = Optional.of(product1);
        when(mockProductRepository.findById(0L)).thenReturn(product);

        // Configure ProductMapper.map(...).
        final ProductResponseDto productResponseDto = new ProductResponseDto(0L, "name", "description",
                new BigDecimal("0.00"), 0, new ProductDetailResponseDto(0L, "color", "imageUrl"),
                new CategoryResponseDto(0L, "name"));
        when(mockProductMapper.map(any(Product.class))).thenReturn(productResponseDto);

        // Run the test
        final ProductResponseDto result = productServiceImplUnderTest.findById(0L);

        // Verify the results
    }

    @Test
    public void testFindById_ProductRepositoryReturnsAbsent() {
        // Setup
        when(mockProductRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThrows(RuntimeException.class, () -> productServiceImplUnderTest.findById(0L));
    }

    @Test
    public void testSearchByCriteria() {
        // Setup
        final List<SearchCriteria> dto = List.of(new SearchCriteria("key", "value", SearchOperation.GREATER_THAN));

        // Configure ProductRepository.findAll(...).
        final Product product = new Product();
        product.setId(0L);
        product.setName("name");
        product.setDescription("description");
        product.setPrice(new BigDecimal("0.00"));
        final Category category = new Category();
        product.setCategory(category);
        final List<Product> products = List.of(product);
        when(mockProductRepository.findAll(any(Specification.class))).thenReturn(products);

        // Configure ProductMapper.map(...).
        final ProductResponseDto productResponseDto = new ProductResponseDto(0L, "name", "description",
                new BigDecimal("0.00"), 0, new ProductDetailResponseDto(0L, "color", "imageUrl"),
                new CategoryResponseDto(0L, "name"));
        when(mockProductMapper.map(any(Product.class))).thenReturn(productResponseDto);

        // Run the test
        final ResponseEntity<List<ProductResponseDto>> result = productServiceImplUnderTest.searchByCriteria(dto);

        // Verify the results
        verify(mockRootSpecification).add(any(SearchCriteria.class));
    }

    @Test
    public void testSearchByCriteria_ProductRepositoryReturnsNoItems() {
        // Setup
        final List<SearchCriteria> dto = List.of(new SearchCriteria("key", "value", SearchOperation.GREATER_THAN));
        when(mockProductRepository.findAll(any(Specification.class))).thenReturn(Collections.emptyList());

        // Run the test
        final ResponseEntity<List<ProductResponseDto>> result = productServiceImplUnderTest.searchByCriteria(dto);

        // Verify the results
        assertEquals(ResponseEntity.ok(Collections.emptyList()), result);
        verify(mockRootSpecification).add(any(SearchCriteria.class));
    }
}
