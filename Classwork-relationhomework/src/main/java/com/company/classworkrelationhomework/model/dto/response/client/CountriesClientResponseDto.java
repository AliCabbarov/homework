package com.company.classworkrelationhomework.model.dto.response.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountriesClientResponseDto {
    String error;
    String msg;
    List<CountryClientResponseDto> data;
}
