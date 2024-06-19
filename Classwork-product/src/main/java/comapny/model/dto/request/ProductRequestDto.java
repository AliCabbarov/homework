package comapny.model.dto.request;

import comapny.model.enums.Category;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class ProductRequestDto {
    private String name;
    private BigDecimal price;
    private Category category;
    private String description;
}
