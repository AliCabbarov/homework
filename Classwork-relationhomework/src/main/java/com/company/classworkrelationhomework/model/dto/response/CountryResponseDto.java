package com.company.classworkrelationhomework.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CountryResponseDto {
    private long id;
    private String name;
    private String iso2;
    private String iso3;
    private Long population;
    private String nativeLang;
    private Integer plateCode;
}
