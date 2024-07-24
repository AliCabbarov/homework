package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.mapper.CountryMapper;
import com.company.classworkrelationhomework.model.dto.request.CountryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CountryResponseDto;
import com.company.classworkrelationhomework.model.entity.Country;
import com.company.classworkrelationhomework.repository.CountryRepository;
import com.company.classworkrelationhomework.service.CountryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;
    private final RedisTemplate<String, Country> countryCache;
    private final RedisTemplate<String, List<Country>> countryCacheList;

    private final String COUNTRY_CACHE_LIST = "countryCacheList";

    @PostConstruct
    public void setUp() {;
        List<Country> countries = countryRepository.findAll(Sort.by("id"));
        countries.forEach(country ->
                countryCache.opsForValue().set(COUNTRY_CACHE_LIST + country.getId(), country));
        countryCacheList.opsForValue().set(COUNTRY_CACHE_LIST, countries);
    }

    @Override
    public ResponseEntity<Void> create(CountryRequestDto dto) {
        Country country = countryMapper.map(dto);
        Country saved = countryRepository.save(country);
        resetCacheList(saved);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<CountryResponseDto>> getAll() {
        List<Country> countries = countryCacheList.opsForValue().get(COUNTRY_CACHE_LIST);

        if (countries == null || countries.isEmpty()) {
            countries = countryRepository.findAll();
            countryCacheList.opsForValue().set(COUNTRY_CACHE_LIST, countries);
        }

        List<CountryResponseDto> responseFromRedis = countries.stream().map(countryMapper::map).toList();

        return ResponseEntity.ok(responseFromRedis);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        try {
            Country country = getById(id);
            countryRepository.deleteById(id);

            resetCacheList(country);

        } catch (RuntimeException e) {
            ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CountryResponseDto> findById(Long id) {

        if (countryCache.opsForValue().get(COUNTRY_CACHE_LIST + id) == null) {
            setUp();
        }

        Country country = countryCache.opsForValue().get(COUNTRY_CACHE_LIST + id);

        if (country == null) {
            throw new RuntimeException("Country not found the given id => " + id);
        }

        return ResponseEntity.ok(countryMapper.map(country));
    }

    private Country getById(Long id) {
        return countryRepository.findById(id).orElseThrow();
    }

    private void resetCacheList(Country country) {
        countryCache.opsForValue().getAndDelete(COUNTRY_CACHE_LIST + country.getId());
        countryCacheList.opsForValue().set(COUNTRY_CACHE_LIST, new ArrayList<>(0));
    }
}
