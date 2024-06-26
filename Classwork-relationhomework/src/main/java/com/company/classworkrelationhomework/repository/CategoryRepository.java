package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}