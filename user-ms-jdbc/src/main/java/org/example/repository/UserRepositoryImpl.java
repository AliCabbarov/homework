package org.example.repository;

import org.example.model.config.DbConnection;
import org.example.model.entity.User;
import org.example.model.exception.ApplicationException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.example.model.enums.ExceptionEnums.USER_NOT_FOUND;
import static org.example.queries.UserQuery.*;

public class UserRepositoryImpl implements UserRepository {
    private final DbConnection dbConnection;

    public UserRepositoryImpl() {
        dbConnection = new DbConnection();
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = dbConnection.connectDb()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                users.add(new User(id, name, surname, username, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByUserName(String username) {
        User user = null;
        try (Connection connection = dbConnection.connectDb()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new ApplicationException(USER_NOT_FOUND);
            }
                long id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String password = resultSet.getString("password");
                user = new User(id, name, surname, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public User findById(long id) {
        User user = null;
        try (Connection connection = dbConnection.connectDb()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new ApplicationException(USER_NOT_FOUND);
            }

            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            user = new User(id, name, surname, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean deleteUserById(long id) {
        int affectedRow = 0;
        try (Connection connection = dbConnection.connectDb()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);

            preparedStatement.setLong(1, id);
            affectedRow = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRow > 0;
    }

    @Override
    public boolean updateUserById(User user) {
        int affectedRow = 0;
        try (Connection connection = dbConnection.connectDb()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setLong(6, user.getId());


            affectedRow = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRow > 0;
    }

    @Override
    public boolean insertUser(User user) {
        int affectedRow = 0;
        try (Connection connection = dbConnection.connectDb()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));

            affectedRow = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRow > 0;
    }
}
