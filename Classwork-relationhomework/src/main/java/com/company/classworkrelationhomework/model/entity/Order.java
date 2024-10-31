package com.company.classworkrelationhomework.model.entity;

import com.company.classworkrelationhomework.model.enums.OrderStatus;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.math.BigDecimal;

@Entity(name = "_order")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Builder.Default
    private BigDecimal amount = BigDecimal.ZERO;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @ManyToOne
    Company company;
}
