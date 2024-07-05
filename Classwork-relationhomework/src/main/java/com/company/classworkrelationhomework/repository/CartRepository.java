package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}