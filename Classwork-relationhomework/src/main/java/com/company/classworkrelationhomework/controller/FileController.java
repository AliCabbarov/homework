package com.company.classworkrelationhomework.controller;

import com.company.classworkrelationhomework.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.nio.file.Path;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;
    @PostMapping("/download")
    @SneakyThrows
    public ResponseEntity<String> download(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(fileService.download(file));
    }
    @GetMapping("/upload/{name}")
    @SneakyThrows
    public ResponseEntity<Resource> upload(@PathVariable String name) {
        return fileService.upload(name);
    }
    @GetMapping("/read/{name}")
    @SneakyThrows
    public ResponseEntity<String> readAsString(@PathVariable String name) {
        return ResponseEntity.ok(fileService.readFileAsString(name));
    }


}
