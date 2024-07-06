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
@ToString
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    @ToString.Exclude
    @ManyToMany()
    Set<Product> products;
}
