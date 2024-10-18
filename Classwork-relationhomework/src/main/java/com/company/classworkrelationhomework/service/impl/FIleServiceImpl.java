package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
public class FIleServiceImpl implements FileService {
    @Value("${file.upload.url}")
    private String fileUploadURl;

    @Override
    public ResponseEntity<Resource> upload(String name) throws IOException {
        Path path = Path.of(fileUploadURl + name);
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        String contentType = Files.probeContentType(Path.of(String.format(fileUploadURl + "%s", name)));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + name + "\"")
                .body(resource);
    }

    @Override
    public String download(MultipartFile file) throws IOException {

        createDirectoriesIfNotExist();

        String[] split = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        String fileExtension = split[split.length - 1];

        LocalDateTime now = LocalDateTime.now();

        String fileFullName = String.format("%d_%d_%d_%d_%d_%d_%s.%s",
                now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                now.getHour(), now.getMinute(), now.getSecond(), UUID.randomUUID(), fileExtension);


        Path filesPath = Path.of(fileUploadURl);
        Path fileFullPath = filesPath.resolve(fileFullName);

        file.transferTo(fileFullPath);

        return fileFullPath.toString();
    }

    @Override
    public String readFileAsString(String name) throws URISyntaxException, IOException {
        return Files.readString(Path.of(String.format(fileUploadURl + "%s", name)));
    }

    private HttpHeaders buildHeaders(String fileName,String contentType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType(contentType));
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        return httpHeaders;
    }

    private void createDirectoriesIfNotExist() throws IOException {

        if (Files.notExists(Path.of(fileUploadURl))) {
            Files.createDirectories(Path.of(fileUploadURl));
        }

    }
}
