package com.company.classworkrelationhomework.mapper;

import com.company.classworkrelationhomework.model.dto.request.ProductRequestDto;
import com.company.classworkrelationhomework.model.dto.response.ProductResponseDto;
import com.company.classworkrelationhomework.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
@SuppressWarnings("all")
public interface ProductMapper {
    @Mapping(target = "category", ignore = true)
    Product map(ProductRequestDto dto);

    ProductResponseDto map(Product product);
    List<ProductResponseDto> map(List<Product> product);
}
