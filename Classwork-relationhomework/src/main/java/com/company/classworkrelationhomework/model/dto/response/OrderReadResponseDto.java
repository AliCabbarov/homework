package com.company.classworkrelationhomework.model.dto.response;

import com.company.classworkrelationhomework.model.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderReadResponseDto {
    private long id;
    private BigDecimal amount;
    private OrderStatus orderStatus;
}
