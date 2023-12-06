package org.example.repository;

import org.example.model.entity.User;

import java.nio.file.LinkOption;
import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findByUserName(String username);
    User findById(long id);
    boolean deleteUserById(long id);
    boolean updateUserById(User user);
    boolean insertUser(User user);
}
