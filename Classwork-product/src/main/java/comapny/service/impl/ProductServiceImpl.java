package comapny.service.impl;

import comapny.mapper.ProductMapper;
import comapny.model.dto.request.ProductRequestDto;
import comapny.model.dto.response.ProductResponseDto;
import comapny.model.entity.Product;
import comapny.model.projection.ProductProjection;
import comapny.repository.ProductRepository;
import comapny.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ResponseEntity<ProductResponseDto> create(ProductRequestDto dto) {
        Product product = productMapper.map(dto);

        Product saved = productRepository.save(product);

        ProductResponseDto returned = productMapper.map(saved);

        return ResponseEntity.ok(returned);
    }

    @Override
    public ResponseEntity<Page<ProductResponseDto>> getAll(Double firstPrice, Double secondPrice, int pageNumber, int pageSize, String sort) {
        Sort by = Sort.by(Sort.Order.by(sort));
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, by);
        Page<Product> products = productRepository
                .findAllByPriceGreaterThanAndPriceIsLessThanEqual(BigDecimal.valueOf(firstPrice), BigDecimal.valueOf(secondPrice), pageRequest);
        Page<ProductResponseDto> productResponseDtos = products
                .map(productMapper::map);
        return ResponseEntity.ok(productResponseDtos);
    }

    @Override
    public ResponseEntity<Map<String, Long>> getProductCountByCategory() {

        Map<String, Long> values = new HashMap<>();
        List<ProductProjection> sizeByCategory = productRepository.findSizeByCategory();
        sizeByCategory
                .stream().filter(productProjection -> productProjection.getCategory() != null)
                .forEach(productProjection ->
                        values.put(productProjection.getCategory(), productProjection.getCount()));

        return ResponseEntity.ok(values);
    }
}
