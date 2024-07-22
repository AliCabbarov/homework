package com.company.classworkrelationhomework.model.dto.specification.product;

import com.company.classworkrelationhomework.model.enums.ProductSort;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductSpecificationDto {
    private String name;
    private Long category;
    private BigDecimal initialPrice;
    private BigDecimal secondPrice;
    private LocalDate initialDate;
    private LocalDate secondDate;
    private ProductSort productSort;
    private Boolean isAsc;
}
