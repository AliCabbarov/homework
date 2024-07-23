package com.company.classworkrelationhomework.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequestDto {
    private String name;
    private Long population;
    private String nativeLang;
    private Integer plateCode;
}
