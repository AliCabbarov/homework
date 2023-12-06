package org.example.service.impl;

import org.example.model.entity.User;
import org.example.model.enums.ExceptionEnums;
import org.example.model.exception.ApplicationException;
import org.example.repository.UserRepository;
import org.example.repository.UserRepositoryImpl;
import org.example.service.UserService;
import org.example.util.InputUtil;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public void findAll() {
        System.out.println(userRepository.findAll());
    }

    @Override
    public void findByUserName() {
        String username = InputUtil.getInstance().inputString("Enter the username:");
        System.out.println(userRepository.findByUserName(username));
    }

    @Override
    public User findById() {
        long id = InputUtil.getInstance().inputLong("Enter the id: ");
        User user = userRepository.findById(id);
        if (user == null) {
            throw new ApplicationException(ExceptionEnums.USER_NOT_FOUND);
        }
        System.out.println(user);
        return user;
    }

    @Override
    public void deleteUserById() {
        findAll();
        User user = findById();
        if (user == null) {
            throw new ApplicationException(ExceptionEnums.USER_NOT_FOUND);
        }

        checkPassword(user);

        String result = userRepository.deleteUserById(user.getId()) ? "Successfully id: " + user.getId() : "Invalid id: " + user.getId();
        System.out.println(result);
    }


    @Override
    public void updateUserById() {
        findAll();
        User user = findById();
        checkPassword(user);

        System.out.println("If you dont want to update field then just press enter!!!");
        fillUser(user, "update");

        String result = userRepository.updateUserById(user) ? "Successfully id: " + user.getId() : "Invalid id: " + user.getId();
        System.out.println(result);
    }

    @Override
    public void insertUser() {

        User user = fillUser(null, "Insert ");

        String result = userRepository.insertUser(user) ? "Successfully!!!" + user.getId() : "Invalid!!!" + user.getId();
        System.out.println(result);
    }

    private void checkPassword(User user) {
        String password = InputUtil.getInstance().inputString("Enter the password: ");

        if (!user.getPassword().equals(password)) {
            throw new ApplicationException(ExceptionEnums.PASSWORD_NOT_VALID);
        }
    }

    private User fillUser(User user, String title) {
        String name = InputUtil.getInstance().inputString(title + " name: ");
        String surname = InputUtil.getInstance().inputString(title + " surname: ");
        String username = InputUtil.getInstance().inputString(title + " username: ");
        String password = InputUtil.getInstance().inputString(title + " password: ");

        if (user == null){
            user = new User();
        }

        user.setName(name.isBlank() ? user.getName() : name);
        user.setSurname(surname.isBlank() ? user.getSurname() : surname);
        user.setUsername(username.isBlank() ? user.getUsername() : username);
        user.setPassword(password.isBlank() ? user.getPassword() : password);
        return user;
    }
}
