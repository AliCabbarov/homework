package com.company.classworkrelationhomework.specification;

import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.model.enums.ProductSort;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductSpecification {

    public Specification<Product> hasName(String name) {
        return (root, query, criteriaBuilder) -> name != null ? criteriaBuilder.equal(root.get("name"),name) : criteriaBuilder.conjunction();
    }
    public Specification<Product> greaterThanPrice(BigDecimal price) {
        return (root, query, criteriaBuilder) -> price != null ? criteriaBuilder.greaterThan(root.get("price"),price) : criteriaBuilder.conjunction();
    }
    public Specification<Product> lessThanPrice(BigDecimal price) {
        return (root, query, criteriaBuilder) -> price != null ? criteriaBuilder.lessThan(root.get("price"),price) : criteriaBuilder.conjunction();
    }
    public Specification<Product> none() {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
    }
    public Specification<Product> sorted(ProductSort sort, Boolean isAsc) {
        return (root, query, criteriaBuilder) -> {
            if (isAsc) query.orderBy(criteriaBuilder.asc(root.get(sort.getParam())));
            else query.orderBy(criteriaBuilder.desc(root.get(sort.getParam())));
            return criteriaBuilder.conjunction();
        };
    }

}
