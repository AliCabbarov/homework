package com.company.firstspringproject.service.impl;

import com.company.firstspringproject.model.constant.Constant;
import com.company.firstspringproject.model.entity.User;
import com.company.firstspringproject.model.enums.ExceptionEnums;
import com.company.firstspringproject.model.exception.ApplicationException;
import com.company.firstspringproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.company.firstspringproject.repository.GlobalData.users;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        return users.stream().filter(User::isStatus).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        users.add(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> findById(long id) {
        User findUser = users.stream()
                .filter(user -> user.getId() == id && user.isStatus())
                .findAny()
                .orElseThrow(() -> new ApplicationException(ExceptionEnums.USER_NOT_FOUND_EXCEPTION));

        return new ResponseEntity<>(findUser,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> findByUsername(String username) {
        User findUser = users.stream()
                .filter(user -> user.getUsername().equals(username) && user.isStatus())
                .findAny()
                .orElseThrow(() -> new ApplicationException(ExceptionEnums.USER_NOT_FOUND_EXCEPTION));
        return new ResponseEntity<>(findUser,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateById(long id, User user) {
        User oldUser = findById(id).getBody();
        int userIndex = users.indexOf(oldUser);
        users.set(userIndex,user);

        return new ResponseEntity<>(Constant.UPDATE_SUCCESSFULLY,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(long id) {
        User deletedUser = findById(id).getBody();
        deletedUser.setStatus(false);
        return new ResponseEntity<>(Constant.DELETE_SUCCESSFULLY,HttpStatus.OK);
    }
}
