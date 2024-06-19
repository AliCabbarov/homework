package comapny.controller;

import comapny.model.dto.request.ProductRequestDto;
import comapny.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductRequestDto dto) {
        return productService.create(dto);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false, defaultValue = "0") Double firstPrice,
                                    @RequestParam(required = false, defaultValue = "1000000") Double secondPrice,
                                    @RequestParam(required = false, defaultValue = "0") int pageNumber,
                                    @RequestParam(required = false, defaultValue = "10") int pageSize,
                                    @RequestParam(required = false,defaultValue = "price")String sort) {
        return productService.getAll(firstPrice, secondPrice, pageNumber, pageSize,sort);
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String,Long>> productCountByCategory() {
        return productService.getProductCountByCategory();
    }
}
