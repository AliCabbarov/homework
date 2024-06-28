package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long quantity;
    private BigDecimal price;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Product product;

    public OrderProduct(long quantity, Order order, Product product,BigDecimal price) {
        this.quantity = quantity;
        this.order = order;
        this.product = product;
        this.price = price;
    }
}
