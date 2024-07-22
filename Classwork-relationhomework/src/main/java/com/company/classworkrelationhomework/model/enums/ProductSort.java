package com.company.classworkrelationhomework.model.enums;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public enum ProductSort {
    NAME("name"),
    PRICE("price"),
    ID("id");

    private final String param;

    ProductSort(String param) {
        this.param = param;
    }
}
