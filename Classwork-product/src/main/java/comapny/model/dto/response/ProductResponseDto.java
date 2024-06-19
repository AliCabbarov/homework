package comapny.model.dto.response;

import comapny.model.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private String description;
}
