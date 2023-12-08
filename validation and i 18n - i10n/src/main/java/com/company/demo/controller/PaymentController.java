package com.company.demo.controller;

import com.company.demo.model.dto.request.TransferDto;
import com.company.demo.model.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.company.demo.model.dto.request.TransferDto.NOT_FOUND;

@RequestMapping("/payment")
@RestController
@Slf4j
public class PaymentController {
    @GetMapping("/testWithBindingResult")
    public ResponseEntity<String> test(@RequestBody @Valid TransferDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().
                    forEach(fieldError -> log.error("{} is invalid: {}", fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return ResponseEntity.ok(dto.toString());

    }

    @GetMapping("/testWithGlobalHandler")
    public ResponseEntity<String> test1(@RequestBody @Valid TransferDto dto) {
        return ResponseEntity.ok(dto.toString());
    }

    @GetMapping("/{username}")
    public String test3(@PathVariable @NotBlank(message = NOT_FOUND) String username) {
        if (!username.equals("a")) {
            throw new NotFoundException(username);
        }
        return username;
    }
}
