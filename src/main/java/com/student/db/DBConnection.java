package com.student.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/student_result_db?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "sspptmkk";

    public static Connection getConnection() throws Exception {

        System.out.println(">>> DBConnection.getConnection() CALLED <<<");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        System.out.println("CONNECTED TO DB: " + con.getCatalog());

        return con;
    }
}
