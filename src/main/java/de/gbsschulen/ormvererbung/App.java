package de.gbsschulen.ormvererbung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";
    private static final String DB_NAME = "ormvererbung";

    public static void main(String[] args) {
        createDB();
    }

    private static void createDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/", DB_USER, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DROP DATABASE IF EXISTS " + DB_NAME);
            stmt.executeUpdate("CREATE DATABASE " + DB_NAME);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
