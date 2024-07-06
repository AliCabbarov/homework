package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.util.Lazy;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
    Set<Cart> carts;
}
