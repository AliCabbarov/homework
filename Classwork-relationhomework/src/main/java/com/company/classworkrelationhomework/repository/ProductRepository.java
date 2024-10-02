package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.projection.IncomeCalculation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Override
    @EntityGraph(attributePaths = {"productDetail","category"})
    List<Product> findAll(Specification<Product> spec);

    @Override
    @EntityGraph(attributePaths = {"productDetail","category"})
    List<Product> findAll();

    @Override
    @EntityGraph(attributePaths = {"productDetail","category"})
    List<Product> findAll(Sort sort);


    @Override
    @Query(value = """
            select p from Product  p
            left join fetch p.category
            left join fetch p.productDetail where p.id =:id
            """)
    Optional<Product> findById(@Param("id")Long id);

    boolean existsByName(String name);
}