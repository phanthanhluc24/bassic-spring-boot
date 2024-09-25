package com.example.SpringBoot.repository.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseRepository {
    static String jdbcURL = "jdbc:mysql://localhost:3306/manage_student?useSSL=false&serverTimezone=UTC";
    static String jdbcName = "root";
    static String jdbcPassword = "";
    static Connection connection;

    public static Connection getConnection (){
        if (connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");

                connection = DriverManager.getConnection(jdbcURL,jdbcName,jdbcPassword);
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }
}
