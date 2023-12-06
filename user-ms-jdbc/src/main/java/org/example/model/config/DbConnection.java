package org.example.model.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DbConnection {
    private final Properties properties = getDbProperties();
    private final String driver = properties.getProperty("driver");
    private final String url = properties.getProperty("url");
    private final String username = properties.getProperty("username");
    private final String password = properties.getProperty("password");

    public Connection connectDb() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Class.forName(driver);


            if (connection != null) {
                String[] split = url.split("/");
                System.out.println("Connected %s db " + split[split.length - 1].substring(0,split[split.length-1].indexOf("?")));
            }
            return connection;

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    private Properties getDbProperties() {
        try (InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("application-db.properties")) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
