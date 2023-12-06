package org.example.model.entity;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.example.model.enums.Status;
import org.example.model.exception.ApplicationException;

import java.time.LocalDateTime;

import static org.example.model.enums.ExceptionEnums.PASSWORD_NOT_VALID;

@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    long id;
    String name;
    String surname;
    String username;
    @ToString.Exclude
    String password;
    @ToString.Exclude
    LocalDateTime createdAt;
    @ToString.Exclude
    LocalDateTime updatedAt;

    {
        updatedAt = LocalDateTime.now();
    }

    public User(long id,String name, String surname, String username, String password) {
        this.id = id;
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
    }

    public User() {

    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname.trim().toLowerCase();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() > 5) {
            this.password = password;
        } else {
            throw new ApplicationException(PASSWORD_NOT_VALID);
        }
    }
}
