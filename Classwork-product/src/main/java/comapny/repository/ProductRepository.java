package comapny.repository;

import comapny.model.entity.Product;
import comapny.model.enums.Category;
import comapny.model.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByPriceGreaterThanAndPriceIsLessThanEqual(BigDecimal firstPrice, BigDecimal secondPrice, Pageable pageable);

    @Query("select p.category as category, count(p) as count from Product p group by p.category")
    List<ProductProjection> findSizeByCategory();
}