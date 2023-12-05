package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
5	Jdbc - part 1 - Java Database Connectivity
5.1	Class.forName(), Connection, DriverManager
5.2	Statement, .execute(), .executeQuery(), .executeUpdate()
Date,  language db structure, ResultSet
5.3	Sql injection
         */

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=university-ms";
            String username = "postgres";
            String password = "123456";

            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                String[] split = url.split("/");
                System.out.printf("Connected %s db\n", split[split.length - 1]);
            } else {
                System.out.println("Connection failed!");
            }
            Statement statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String email = scanner.nextLine();

            System.out.print("Enter password: ");
            String passwordAcc = scanner.nextLine();
            ResultSet resultSet = statement.executeQuery("SELECT * from student where email = '" + email + "' and password = '" + passwordAcc + "'");
            while (resultSet.next()) {
                String emailRow = resultSet.getString("email");
                String passwordRow = resultSet.getString("password");
                double fee = resultSet.getDouble("fee");
                System.out.println(emailRow + " - " + passwordRow + " - " + fee);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}