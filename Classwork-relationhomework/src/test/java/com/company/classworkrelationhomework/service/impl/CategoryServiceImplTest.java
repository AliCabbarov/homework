package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.CategoryMapper;
import com.company.classworkrelationhomework.model.dto.request.CategoryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CategoryResponseDto;
import com.company.classworkrelationhomework.model.entity.Category;
import com.company.classworkrelationhomework.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;

import java.lang.ref.WeakReference;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryMapper mockCategoryMapper;
    @Mock
    private CategoryRepository mockCategoryRepository;
    @Mock
    private WeakReference<HashMap<Long, Category>> mockCategoryCache;

    private CategoryServiceImpl categoryServiceImplUnderTest;

    @Before
    public void setUp() {
        categoryServiceImplUnderTest = new CategoryServiceImpl(mockCategoryMapper, mockCategoryRepository);
        // TODO: Set the following fields: categoryCache.
    }

    @Test
    public void testCreate() {
        // Setup
        final CategoryRequestDto dto = new CategoryRequestDto("name");

        // Configure CategoryMapper.map(...).
        final Category category = new Category();
        category.setId(0L);
        category.setName("name");
        when(mockCategoryMapper.map(any(CategoryRequestDto.class))).thenReturn(category);

        // Configure CategoryRepository.save(...).
        final Category category1 = new Category();
        category1.setId(0L);
        category1.setName("name");
        when(mockCategoryRepository.save(any(Category.class))).thenReturn(category1);

        // Configure WeakReference.get(...).
        final Category category2 = new Category();
        category2.setId(0L);
        category2.setName("name");
        final HashMap<Long, Category> longCategoryHashMap = new HashMap<>(Map.ofEntries(Map.entry(0L, category2)));
        when(mockCategoryCache.get()).thenReturn(longCategoryHashMap);

        when(mockCategoryMapper.map(any(Category.class))).thenReturn(new CategoryResponseDto(0L, "name"));

        // Run the test
        final ResponseEntity<CategoryResponseDto> result = categoryServiceImplUnderTest.create(dto);

        // Verify the results
    }

    @Test
    public void testCreate_CategoryRepositoryThrowsOptimisticLockingFailureException() {
        // Setup
        final CategoryRequestDto dto = new CategoryRequestDto("name");

        // Configure CategoryMapper.map(...).
        final Category category = new Category();
        category.setId(0L);
        category.setName("name");
        when(mockCategoryMapper.map(any(CategoryRequestDto.class))).thenReturn(category);

        when(mockCategoryRepository.save(any(Category.class))).thenThrow(OptimisticLockingFailureException.class);

        // Run the test
        assertThrows(OptimisticLockingFailureException.class, () -> categoryServiceImplUnderTest.create(dto));
    }

    @Test
    public void testCreate_WeakReferenceReturnsNull() {
        // Setup
        final CategoryRequestDto dto = new CategoryRequestDto("name");

        // Configure CategoryMapper.map(...).
        final Category category = new Category();
        category.setId(0L);
        category.setName("name");
        when(mockCategoryMapper.map(any(CategoryRequestDto.class))).thenReturn(category);

        // Configure CategoryRepository.save(...).
        final Category category1 = new Category();
        category1.setId(0L);
        category1.setName("name");
        when(mockCategoryRepository.save(any(Category.class))).thenReturn(category1);

        when(mockCategoryCache.get()).thenReturn(null);
        when(mockCategoryMapper.map(any(Category.class))).thenReturn(new CategoryResponseDto(0L, "name"));

        // Run the test
        final ResponseEntity<CategoryResponseDto> result = categoryServiceImplUnderTest.create(dto);

        // Verify the results
    }

    @Test
    public void testGetCategoryById() {
        // Setup
        // Configure WeakReference.get(...).
        final Category category = new Category();
        category.setId(0L);
        category.setName("name");
        final HashMap<Long, Category> longCategoryHashMap = new HashMap<>(Map.ofEntries(Map.entry(0L, category)));
        when(mockCategoryCache.get()).thenReturn(longCategoryHashMap);

        // Configure CategoryRepository.findById(...).
        final Category category2 = new Category();
        category2.setId(0L);
        category2.setName("name");
        final Optional<Category> category1 = Optional.of(category2);
        when(mockCategoryRepository.findById(0L)).thenReturn(category1);

        // Run the test
        final Category result = categoryServiceImplUnderTest.getCategoryById(0L);

        // Verify the results
    }

    @Test
    public void testGetCategoryById_WeakReferenceReturnsNull() {
        // Setup
        when(mockCategoryCache.get()).thenReturn(null);

        // Run the test
        final Category result = categoryServiceImplUnderTest.getCategoryById(0L);

        // Verify the results
    }

    @Test
    public void testGetCategoryById_CategoryRepositoryReturnsAbsent() {
        // Setup
        // Configure WeakReference.get(...).
        final Category category = new Category();
        category.setId(0L);
        category.setName("name");
        final HashMap<Long, Category> longCategoryHashMap = new HashMap<>(Map.ofEntries(Map.entry(0L, category)));
        when(mockCategoryCache.get()).thenReturn(longCategoryHashMap);

        when(mockCategoryRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThrows(RuntimeException.class, () -> categoryServiceImplUnderTest.getCategoryById(0L));
    }

    @Test
    public void testGetAll() {
        // Setup
        // Configure CategoryRepository.findAll(...).
        final Category category = new Category();
        category.setId(0L);
        category.setName("name");
        final List<Category> categories = List.of(category);
        when(mockCategoryRepository.findAll()).thenReturn(categories);

        // Configure CategoryMapper.map(...).
        final List<CategoryResponseDto> categoryResponseDtos = List.of(new CategoryResponseDto(0L, "name"));
        final Category category1 = new Category();
        category1.setId(0L);
        category1.setName("name");
        final List<Category> categories1 = List.of(category1);
        when(mockCategoryMapper.map(categories1)).thenReturn(categoryResponseDtos);

        // Run the test
        final ResponseEntity<List<CategoryResponseDto>> result = categoryServiceImplUnderTest.getAll();

        // Verify the results
    }

    @Test
    public void testGetAll_CategoryRepositoryReturnsNoItems() {
        // Setup
        when(mockCategoryRepository.findAll()).thenReturn(Collections.emptyList());

        // Configure CategoryMapper.map(...).
        final List<CategoryResponseDto> categoryResponseDtos = List.of(new CategoryResponseDto(0L, "name"));
        final Category category = new Category();
        category.setId(0L);
        category.setName("name");
        final List<Category> categories = List.of(category);
        when(mockCategoryMapper.map(categories)).thenReturn(categoryResponseDtos);

        // Run the test
        final ResponseEntity<List<CategoryResponseDto>> result = categoryServiceImplUnderTest.getAll();

        // Verify the results
        assertEquals(ResponseEntity.ok(Collections.emptyList()), result);
    }

    @Test
    public void testGetAll_CategoryMapperReturnsNoItems() {
        // Setup
        // Configure CategoryRepository.findAll(...).
        final Category category = new Category();
        category.setId(0L);
        category.setName("name");
        final List<Category> categories = List.of(category);
        when(mockCategoryRepository.findAll()).thenReturn(categories);

        // Configure CategoryMapper.map(...).
        final Category category1 = new Category();
        category1.setId(0L);
        category1.setName("name");
        final List<Category> categories1 = List.of(category1);
        when(mockCategoryMapper.map(categories1)).thenReturn(Collections.emptyList());

        // Run the test
        final ResponseEntity<List<CategoryResponseDto>> result = categoryServiceImplUnderTest.getAll();

        // Verify the results
    }

    @Test
    public void testDeleteById() {
        // Setup
        // Configure WeakReference.get(...).
        final Category category = new Category();
        category.setId(0L);
        category.setName("name");
        final HashMap<Long, Category> longCategoryHashMap = new HashMap<>(Map.ofEntries(Map.entry(0L, category)));
        when(mockCategoryCache.get()).thenReturn(longCategoryHashMap);

        // Run the test
        final ResponseEntity<Void> result = categoryServiceImplUnderTest.deleteById(0L);

        // Verify the results
        verify(mockCategoryRepository).deleteById(0L);
    }

    @Test
    public void testDeleteById_WeakReferenceReturnsNull() {
        // Setup
        when(mockCategoryCache.get()).thenReturn(null);

        // Run the test
        final ResponseEntity<Void> result = categoryServiceImplUnderTest.deleteById(0L);

        // Verify the results
        verify(mockCategoryRepository).deleteById(0L);
    }
}
