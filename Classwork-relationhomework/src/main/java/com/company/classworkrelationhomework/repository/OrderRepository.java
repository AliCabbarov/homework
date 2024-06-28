package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}