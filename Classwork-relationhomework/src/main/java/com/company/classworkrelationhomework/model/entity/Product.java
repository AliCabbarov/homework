package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    @ManyToOne
    private Category category;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private ProductDetail productDetail;
}
