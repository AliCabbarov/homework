package org.example.queries;

import org.example.model.entity.User;

public final class UserQuery {
    private UserQuery(){

    }

    public static final String INSERT_USER = "insert into _user(name, surname, username, password, created_at, updated_at) " +
            "values(?, ?, ?, ?, ?, ?)";

    public static final String UPDATE_USER = "update _user set name = ?, surname = ?, username = ?, password = ?, updated_at = ? " +
            "where id = ? and status = 1";
    public static  final String FIND_ALL = "select * from _user where status = 1 order by id";
    public static  final String FIND_BY_ID = "select * from _user where id = ? and status = 1";
    public static final String DELETE_USER = "update _user set status = 0 " +
            "where id = ?";
    public static final String FIND_USER_BY_USERNAME = "select * from _user where username like ? and status = 1";
}
