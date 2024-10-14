package com.company.classworkrelationhomework.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.nio.file.Path;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {
    @GetMapping
    @SneakyThrows
    public ResponseEntity<Resource> download() {
        try {

            Resource resource = new UrlResource(Path.of("output-fe59d6e8-4492-422b-af37-2a9c0fc73a0f.xml").toUri());
            return new ResponseEntity<>(resource, buildHeaders("output-fe59d6e8-4492-422b-af37-2a9c0fc73a0f.xml"), HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new FileNotFoundException();
        }
    }

    public HttpHeaders buildHeaders(String fileName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        return httpHeaders;
    }
}
