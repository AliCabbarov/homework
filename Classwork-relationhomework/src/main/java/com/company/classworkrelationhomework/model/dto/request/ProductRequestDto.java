package com.company.classworkrelationhomework.model.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequestDto {
    @NotBlank
    private String name;
    private String description;
    @NotNull
    @Max(50000)
    private BigDecimal price;
    @NotNull
    @Max(10000)
    private Integer quantity;
    private ProductDetailRequestDto productDetail;
    private long categoryId;
}
