package com.company.classworkrelationhomework.mapper;

import com.company.classworkrelationhomework.model.dto.request.CategoryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CategoryResponseDto;
import com.company.classworkrelationhomework.model.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category map(CategoryRequestDto dto);
    CategoryResponseDto map(Category category);
    List<CategoryResponseDto> map(List<Category> categories);

}
