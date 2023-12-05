package com.company.firstspringproject.service;

import com.company.firstspringproject.model.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> findAll();
    ResponseEntity<User> createUser(User user);

    ResponseEntity<User> findById(long id);
    ResponseEntity<User> findByUsername(String username);
    ResponseEntity<String> updateById(long id, User user);
    ResponseEntity<String> deleteById(long id);
}
