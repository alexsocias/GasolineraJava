package com.example.gasolinerajava;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class dbTable {
    public static void createTable(Connection dbConnection) throws SQLException {
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
            String tablaCombustible = "CREATE TABLE IF NOT EXISTS Combustible" +
                    "(id int primary key not null, " +
                    "tipo_combustible VARCHAR(20) not null, " +
                    "precio DECIMAL(10, 2) not null)";
            statement.executeUpdate(tablaCombustible);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }

    public static void insertData(Connection dbConnection) throws SQLException {
        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
            String insertCombustible = "INSERT INTO Combustible (id, tipo_combustible, precio) VALUES " +
                    "(1, 'diesel', 3.25), " +
                    "(2, 'gasolina', 3.50)";
            statement.executeUpdate(insertCombustible);
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
}
