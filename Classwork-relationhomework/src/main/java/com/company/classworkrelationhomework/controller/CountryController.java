package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.model.dto.request.CountryRequestDto;
import com.company.classworkrelationhomework.model.dto.response.CountryResponseDto;
import com.company.classworkrelationhomework.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CountryRequestDto dto){
        return countryService.create(dto);
    }
    @GetMapping
    public ResponseEntity<List<CountryResponseDto>> getAll(){
        return countryService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> getAll(@PathVariable Long id){
        return countryService.delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CountryResponseDto> findById(@PathVariable Long id){
        return countryService.findById(id);
    }
}
