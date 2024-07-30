package com.company.classworkrelationhomework.mapper;

import com.company.classworkrelationhomework.model.dto.request.CountryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CountryResponseDto;
import com.company.classworkrelationhomework.model.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "iso2",ignore = true)
    @Mapping(target = "iso3",ignore = true)
    Country map(CountryRequestDto dto);
    CountryResponseDto map(Country country);
}
