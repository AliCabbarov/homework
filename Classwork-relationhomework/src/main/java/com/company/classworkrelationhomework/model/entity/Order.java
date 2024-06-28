package com.company.classworkrelationhomework.model.entity;

import com.company.classworkrelationhomework.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "_order")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal amount = BigDecimal.ZERO;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
