package com.example.gasolinerajava;
import java.sql.*;

public class dbConnection {
    public static Connection getConnection(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gasolinera", "isaacYalex", "12345678Gasolinera");
            System.out.println("Conexión ha sido establecida");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return dbConnection;
    }
}