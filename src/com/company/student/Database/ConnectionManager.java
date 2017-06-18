package com.company.student.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by AdrianP on 09.06.2017.
 */
public class ConnectionManager {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://173.212.192.223:3306/studentdb?useUnicode=true&characterEncoding=utf-8";
    private static String USER = "studentdb";
    private static String PASS = "3W7b5N9d";
    static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            String errorF = e.getMessage();
            JOptionPane.showMessageDialog(null, "Datu bāze nestrāda" + "\n" + errorF, "Kļūda", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            String errorF = e.getMessage();
            JOptionPane.showMessageDialog(null, "Datu bāze nestrāda" + "\n" + errorF, "Kļūda", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
        return conn;
    }



}
