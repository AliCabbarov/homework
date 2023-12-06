package org.example.service;

import org.example.model.entity.User;

import java.util.List;

public interface UserService {
    void findAll();
    void findByUserName();
    User findById();
    void deleteUserById();
    void updateUserById();
    void insertUser();
}
