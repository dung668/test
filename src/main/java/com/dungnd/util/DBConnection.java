package com.dungnd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String URL = "jdbc:mysql://localhost:3306/tax_sqa?setUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static String USER = "root";
    private static String PASSWORD = "";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getCon() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
