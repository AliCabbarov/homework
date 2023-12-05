package com.company.firstspringproject.controller;

import com.company.firstspringproject.model.entity.User;
import com.company.firstspringproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping("user/")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("find-all")
    public List<User> users() {
        return userService.findAll();
    }

    @PostMapping("registration")
    public ResponseEntity<User> registration(@RequestBody User user) {
        log.info("request -> registration{} - POST", user);
        return userService.createUser(user);
    }

    @GetMapping("find-username/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        log.info("request -> find by username: {} - GET", username);
        return userService.findByUsername(username);
    }

    @GetMapping("find-id/{id}")
    public ResponseEntity<User> findByUsername(@PathVariable long id) {
        log.info("request -> find-id/{} - GET", id);
        ResponseEntity<User> responseUser = userService.findById(id);
        log.info("response -> find-id/{} - GET - model -> {}", id, responseUser);

        return responseUser;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        log.info("request -> delete id: {} - DELETE",id);
        return userService.deleteById(id);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody User user) {
        log.info("request -> update id: {} - PATCH",id);
        return userService.updateById(id, user);
    }

    /**
     * bu hissədən sonra resource-dan file-i oxuyub qaytarmağın yolları yazılıb.
     */
    @GetMapping("image")
    public ResponseEntity<byte[]> showPng() {

        byte[] file = getByteStreamFileName("zed.png");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setContentDispositionFormData("attachment", "zed.png");

        return new ResponseEntity<>(file, httpHeaders, HttpStatus.OK);
    }

    private byte[] getByteStreamFileName(String fileName) {
        Resource resource = new ClassPathResource("static/image/" + fileName);

        try {
            return resource.getInputStream().readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("language")
    public String test(@RequestHeader(value = HttpHeaders.ACCEPT_LANGUAGE, defaultValue = "az") String language) {
        switch (language.toLowerCase()) {
            case "en":
                return "hello world";
            case "ru":
                return "privet mir";
            default:
                return "salam dünya";
        }

    }

    /**
     * file upload and downloaded
     **/
    @GetMapping("upload-file")
    public ResponseEntity<String> uploadFile(@RequestPart MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            byte[] bytes = inputStream.readAllBytes();
            String response = new String(bytes);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            throw new MaxUploadSizeExceededException(5000);

        }
    }

}
