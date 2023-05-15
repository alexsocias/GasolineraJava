package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.gasolinerajava.BBDD.dbConnection;

public class TicketController {

    @FXML
    private Label lblTicket;

    @FXML
    private Label lblCombustible;

    @FXML
    private Label lblLitros;

    @FXML
    private Label lblImporte;

    @FXML
    private Label lblMetodoPago;

    @FXML
    private Button btnVolverEmpezar;

    @FXML
    private Button btnValorar;

    @FXML
    private Label lblIsMember;

    @FXML
    private Label lblMemberNumber;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setTicketInfo(String combustible, String importe, String metodoPago, boolean isMember, String memberNumber) {
        String litros = main.getLitros(); // Obtenemos el valor de litros desde Main
        double litrosNumeric = Double.parseDouble(litros);
        litrosNumeric /= 1.4;
        String litrosAdjusted = String.format("%.2f", litrosNumeric); // Convertimos de nuevo a String, con dos decimales

        lblCombustible.setText("Combustible: " + combustible);
        lblLitros.setText("Litros: " + litrosAdjusted); // Usamos el nuevo valor ajustado
        lblImporte.setText("Importe: " + importe);
        lblMetodoPago.setText("Método de pago: " + metodoPago);
        lblIsMember.setText("es miembro: "+ isMember);
        lblMemberNumber.setText("número de miembro: "+ memberNumber);

        try {
            // Usamos el nuevo valor ajustado
            crearArchivoTicket(combustible, litrosAdjusted, importe, metodoPago, memberNumber);
            insertTicketInfo(combustible, litros, importe, metodoPago, isMember, memberNumber);

        } catch(IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void crearArchivoTicket(String combustible, String litros, String importe, String metodoPago, String memberNumber) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("ticketCompra.txt"));
        writer.write("Combustible: " + combustible);
        writer.newLine();
        writer.write("Litros: " + litros);
        writer.newLine();
        writer.write("Importe: " + importe);
        writer.newLine();
        writer.write("Método de pago: " + metodoPago);
        writer.newLine();
        writer.write("numero de miembro:" + memberNumber);
        writer.newLine();
        writer.close();
    }

    public static void insertTicketInfo(String idCombustible, String litros, String importe, String metodoPago, boolean isMember, String memberNumber) throws SQLException {
        try {
            String alterQuery = "ALTER TABLE MetodoPago ADD COLUMN description VARCHAR(100)";
            Statement statement = dbConnection.createStatement();
            statement.executeUpdate(alterQuery);
            System.out.println("Added data to the ticket table successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleVolverEmpezar() throws Exception {
        main.showLoginScreen();
    }

    @FXML
    private void handleValorar() throws Exception {
        main.showCualificacion();
    }
}

