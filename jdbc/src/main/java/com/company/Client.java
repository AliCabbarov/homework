package com.company;

import java.sql.*;

public class Client {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=employee";
        String username = "postgres";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        if(connection != null){
            System.out.println("Connection successfully - " + username);
        }else {
            System.out.println("Connection failed!!!");
        }
//        statement.execute("CREATE TABLE employee(id bigserial primary key , name varchar,salary float)");
        statement.executeUpdate("INSERT INTO employee (name,salary) values ('Ali',6000),('Nihat',5000)");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
        System.out.println("id\tname\tsalary");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double salary = resultSet.getInt("salary");
            System.out.println(id + "\t"+ name + "\t"+ salary);
        }
    }
}
