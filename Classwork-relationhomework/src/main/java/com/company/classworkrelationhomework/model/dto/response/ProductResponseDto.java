package com.company.classworkrelationhomework.model.dto.response;

import com.company.classworkrelationhomework.model.dto.request.ProductDetailRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDto {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private ProductDetailResponseDto productDetail;
    private CategoryResponseDto category;
}
