package comapny.mapper;

import comapny.model.dto.request.ProductRequestDto;
import comapny.model.dto.response.ProductResponseDto;
import comapny.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    Product map(ProductRequestDto dto);

    ProductResponseDto map(Product product);
}
