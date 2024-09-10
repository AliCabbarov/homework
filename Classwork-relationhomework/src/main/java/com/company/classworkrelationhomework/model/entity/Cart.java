package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart implements Serializable {
    private static final Long serialVersionUID = 123158894L;
    @Id
    @GeneratedValue
    private Long id;
    String name;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Product> products;

}
