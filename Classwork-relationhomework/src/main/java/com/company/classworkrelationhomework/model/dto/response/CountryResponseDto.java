package com.company.classworkrelationhomework.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponseDto {
    private long id;
    private String name;
    private Long population;
    private String nativeLang;
    private Integer plateCode;
}
