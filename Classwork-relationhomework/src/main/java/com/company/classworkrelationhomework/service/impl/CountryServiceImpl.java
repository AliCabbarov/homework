package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.CountryMapper;
import com.company.classworkrelationhomework.model.dto.request.CountryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CountryResponseDto;
import com.company.classworkrelationhomework.model.entity.Country;
import com.company.classworkrelationhomework.repository.CountryRepository;
import com.company.classworkrelationhomework.service.CountryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;
    private final RedisTemplate<Long, Country> countryCache;
    private final RedisTemplate<String, List<Country>> countryCacheList;
    private final String COUNTRY_CACHE_LIST = "countryCacheList";

    @PostConstruct
    public void setUp() {
        List<Country> countries = countryRepository.findAll();
        countries.forEach(country ->
                countryCache.opsForValue().set(country.getId(), country));

        countryCacheList.opsForValue().set(COUNTRY_CACHE_LIST, countries);
    }

    @Override
    public ResponseEntity<Void> create(CountryRequestDto dto) {
        Country country = countryMapper.map(dto);
        Country saved = countryRepository.save(country);

        countryCache.opsForValue().set(saved.getId(), saved);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<CountryResponseDto>> getAll() {
        List<Country> countries = countryCacheList.opsForValue().get(COUNTRY_CACHE_LIST);

        if (countries == null) {
            setUp();

        }

        List<CountryResponseDto> responseFromRedis = countries.stream().map(countryMapper::map).toList();


        return ResponseEntity.ok(responseFromRedis);
    }
}
