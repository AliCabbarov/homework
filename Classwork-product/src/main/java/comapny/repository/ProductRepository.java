package comapny.repository;

import comapny.model.entity.Product;
import comapny.model.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByPriceGreaterThanAndPriceIsLessThanEqual(BigDecimal firstPrice, BigDecimal secondPrice, Pageable pageable);

    @Query("select count(p) from Product p where p.category =:category")
    Long findSizeByCategory(@Param("category") Category category);
}