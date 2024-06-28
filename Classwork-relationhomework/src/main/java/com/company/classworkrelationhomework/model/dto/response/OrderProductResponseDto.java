package com.company.classworkrelationhomework.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductResponseDto {
    private long id;
    private long quantity;
    private BigDecimal price;
    private String name;
}
