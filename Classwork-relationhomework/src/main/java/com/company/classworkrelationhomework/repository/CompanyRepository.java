package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByName(String name);
    @Modifying
    @Transactional
    @Query(value = "call calculate_total_amount(:totalAmount,:id) ",nativeQuery = true)
    void callTotalAmountProcedure(Long id, BigDecimal totalAmount);
}