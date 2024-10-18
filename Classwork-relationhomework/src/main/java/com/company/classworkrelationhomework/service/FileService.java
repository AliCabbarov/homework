package com.company.classworkrelationhomework.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public interface FileService {

    ResponseEntity<Resource> upload(String name) throws IOException, URISyntaxException;
    String download(MultipartFile file) throws URISyntaxException, IOException;
    String readFileAsString(String name) throws URISyntaxException, IOException;
}
