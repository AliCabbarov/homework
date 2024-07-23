package com.company.classworkrelationhomework.client;

import com.company.classworkrelationhomework.model.dto.response.client.CountriesClientResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://countriesnow.space/api/v0.1/countries",name = "country")
public interface CountriesClient {
    @GetMapping
    CountriesClientResponseDto getCountries();
}
