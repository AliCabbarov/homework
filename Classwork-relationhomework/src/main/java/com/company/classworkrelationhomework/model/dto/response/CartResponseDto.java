package com.company.classworkrelationhomework.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CartResponseDto {
    private Long id;
    private String name;
    private List<ProductResponseDto> products;

    public CartResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
