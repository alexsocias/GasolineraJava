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
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306","isaacYalex", "12345678Gasolinera");
            statement = dbConnection.createStatement();
            System.out.println("Conexión establecida");

            // Eliminar base de datos por si acaso
            statement.executeUpdate("drop database if exists gasolinera");

            // Crear tablas
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS gasolinera");

            statement.executeUpdate("use gasolinera");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS MetodoPago (" +
                    "ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT," +
                    "metodo VARCHAR(50))"
            );
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Usuario (" +
                    "numero_socio INT UNSIGNED PRIMARY KEY)"
            );

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Calificaciones (" +
                    "ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT," +
                    "numero_socio INT UNSIGNED," +
                    "valoracion INT," +
                    "FOREIGN KEY (numero_socio) REFERENCES Usuario(numero_socio))"
            );

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Combustible (" +
                    "ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT," +
                    "tipo VARCHAR(50)," +
                    "precio_litro DECIMAL(10, 2))"
            );

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Ticket (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "id_combustible INT UNSIGNED," +
                    "litros DECIMAL(10, 2)," +
                    "importe DECIMAL(10, 2)," +
                    "fecha DATE," +
                    "es_miembro TINYINT(1)," +
                    "numero_socio INT UNSIGNED," +
                    "FOREIGN KEY (id_combustible) REFERENCES Combustible(ID)," +
                    "FOREIGN KEY (numero_socio) REFERENCES Usuario(numero_socio))"
            );


            // Insertar a tablas
            // Inserciones en la tabla Método de Pago
            statement.executeUpdate("INSERT INTO MetodoPago (metodo) VALUES ('Tarjeta')");
            statement.executeUpdate("INSERT INTO MetodoPago (metodo) VALUES ('Efectivo')");

            // Inserciones en la tabla de Combustible
            statement.executeUpdate("INSERT INTO Combustible (tipo, precio_litro) VALUES ('Diesel', 3)");
            statement.executeUpdate("INSERT INTO Combustible (tipo, precio_litro) VALUES ('Gasolina', 1.5)");

            // Inserciones en la tabla Usuario
            statement.executeUpdate("INSERT INTO Usuario (numero_socio) VALUES ('213412')");
            statement.executeUpdate("INSERT INTO Usuario (numero_socio) VALUES ('93827')");
            statement.executeUpdate("INSERT INTO Usuario (numero_socio) VALUES ('2123')");
            statement.executeUpdate("INSERT INTO Usuario (numero_socio) VALUES ('4987')");
            statement.executeUpdate("INSERT INTO Usuario (numero_socio) VALUES ('3456')");

            // Inserciones en la tabla Calificaciones
            statement.executeUpdate("INSERT INTO Calificaciones (numero_socio, valoracion) VALUES (213412, 5)");
            statement.executeUpdate("INSERT INTO Calificaciones (numero_socio, valoracion) VALUES (93827, 4)");
            statement.executeUpdate("INSERT INTO Calificaciones (numero_socio, valoracion) VALUES (4987, 2)");
            statement.executeUpdate("INSERT INTO Calificaciones (numero_socio, valoracion) VALUES (3456, 1)");

            // Cerrar conexión
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validateMember(String memberNumber) throws SQLException {
        String query = "SELECT COUNT(*) FROM Usuario WHERE numero_socio = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setString(1, memberNumber);
        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }

        resultSet.close();
        preparedStatement.close();

        return count > 0;
    }

    public static void insertTicketInfo(String combustible, String litros, String importe, String metodoPago, boolean isMember, String memberNumber) throws SQLException {
        String query = "INSERT INTO Ticket (combustible, litros, importe, metodo_pago, is_member, member_number) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = dbConnection.prepareStatement(query)) {
            statement.setString(1, combustible);
            statement.setString(2, litros);
            statement.setString(3, importe);
            statement.setString(4, metodoPago);
            statement.setBoolean(5, isMember);
            statement.setString(6, memberNumber);

            statement.executeUpdate();
        }
    }

    public static void getUsuarios() throws SQLException {
        String query = "SELECT * FROM Usuario";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String numero_socio = resultSet.getString("numero_socio");
            // Process the retrieved data as needed
            System.out.println("Numero de Socio: " + numero_socio);
        }
        resultSet.close();
    }

    public void executeQuery(String query) throws SQLException {
        try{
            statement = dbConnection.createStatement();
            resultSet = statement.executeQuery(query);
        }catch (SQLException e){
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Cerrar conexión
    //public static void closeConnection() throws SQLException{
    //    try {
    //        dbConnection.close();
    //    } catch (SQLException e) {
    //        throw new RuntimeException(e);
    //    }
    //}
}