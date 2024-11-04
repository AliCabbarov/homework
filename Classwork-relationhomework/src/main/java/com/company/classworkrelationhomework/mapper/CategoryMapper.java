package com.company.classworkrelationhomework.mapper;

import com.company.classworkrelationhomework.model.dto.request.CategoryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CategoryResponseDto;
import com.company.classworkrelationhomework.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id",ignore = true)
    Category map(CategoryRequestDto dto);

    CategoryResponseDto map(Category category);

    List<CategoryResponseDto> map(List<Category> categories);
    List<Category> mapToEntity(List<CategoryRequestDto> categoryRequestDtos);
    //test1

}
