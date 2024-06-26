package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p.quantity * p.price as income, p.name as name from Product p")
    List<IncomeCalculation> calculateIncome();
}