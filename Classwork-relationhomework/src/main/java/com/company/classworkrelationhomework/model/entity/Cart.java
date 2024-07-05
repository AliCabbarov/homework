package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    @ManyToMany
    Set<Product> products;
}
