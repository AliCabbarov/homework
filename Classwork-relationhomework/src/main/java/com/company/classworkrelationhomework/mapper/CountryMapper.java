package com.company.classworkrelationhomework.mapper;

import com.company.classworkrelationhomework.model.dto.request.CountryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CountryResponseDto;
import com.company.classworkrelationhomework.model.entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country map(CountryRequestDto dto);
    CountryResponseDto map(Country country);

}
