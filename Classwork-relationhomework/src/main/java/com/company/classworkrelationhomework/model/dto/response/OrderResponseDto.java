package com.company.classworkrelationhomework.model.dto.response;

import com.company.classworkrelationhomework.model.enums.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private long id;
    private BigDecimal amount;
    private List<OrderProductResponseDto> orderProducts;
    private OrderStatus orderStatus;

    public OrderResponseDto(long id, BigDecimal amount,OrderStatus orderStatus) {
        this.id = id;
        this.amount = amount;
        orderProducts = new ArrayList<>();
        this.orderStatus =  orderStatus;
    }
}
