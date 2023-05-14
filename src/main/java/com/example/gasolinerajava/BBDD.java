package com.example.gasolinerajava;

import java.math.BigDecimal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BBDD {

    protected static Connection dbConnection;
    protected static Statement statement;
    protected ResultSet resultSet;

    // Constructor para establecer conexión
    public BBDD(String className, String connectionChain, String username, String password){
        try{
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName(className);
            dbConnection = DriverManager.getConnection(connectionChain, username, password);
            dbConnection.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // Getters
    public Connection getConnected() {
        return dbConnection;
    }

    public Statement getSentence() {
        return statement;
    }

    public ResultSet getResult() {
        return resultSet;
    }



    public static void createBBDD() throws SQLException {
        dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306","isaacYalex", "12345678Gasolinera");
        statement = dbConnection.createStatement();
        System.out.println("Conexión establecida");

        // Eliminar base de datos por si acaso
        // statement.executeUpdate("drop database if exists gasolinera");

        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS gasolinera");

        statement.executeUpdate("use gasolinera");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS MetodoPago (" +
                "id INT PRIMARY KEY," +
                "metodo VARCHAR(50))"
        );
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Usuario (" +
                "id INT PRIMARY KEY," +
                "nombre VARCHAR(50)," +
                "nie VARCHAR(50))"
        );

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Calificaciones (" +
                "id INT PRIMARY KEY," +
                "usuario_id INT," +
                "valoracion INT," +
                "FOREIGN KEY (usuario_id) REFERENCES Usuario(id))"
        );

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Combustible (" +
                "tipo VARCHAR(50) PRIMARY KEY," +
                "precio_litro DECIMAL(10, 2))"
        );

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Inventario (" +
                "id INT PRIMARY KEY," +
                "combustible_tipo VARCHAR(50)," +
                "FOREIGN KEY (combustible_tipo) REFERENCES Combustible(tipo))"
        );
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Ticket (" +
                "id INT PRIMARY KEY," +
                "combustible_tipo VARCHAR(50)," +
                "importe DECIMAL(10, 2)," +
                "fecha DATE," +
                "FOREIGN KEY (combustible_tipo) REFERENCES Combustible(tipo))"
        );
    }



    public void executeQuery(String query) throws SQLException {
        try{
            statement = dbConnection.createStatement();
            resultSet = statement.executeQuery(query);
        }catch (SQLException e){
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static ResultSet getData(String query) throws SQLException {
        ResultSet queryData = statement.executeQuery(query);
        return queryData;
    }

    // Cerrar conexión

    public static void closeConnection() {
    }
}