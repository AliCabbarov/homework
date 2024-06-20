package comapny.service;

import comapny.model.dto.request.ProductRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProductService {
    ResponseEntity<?> create(ProductRequestDto dto);

    ResponseEntity<?> getAll(Double firstPrice, Double secondPrice, int pageNumber, int pageSize,String sort);

    ResponseEntity<?> getProductCountByCategory();
}
