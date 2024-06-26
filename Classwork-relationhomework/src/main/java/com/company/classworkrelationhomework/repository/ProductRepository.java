package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}