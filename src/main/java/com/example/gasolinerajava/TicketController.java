package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    private Label lblIsMember;
    @FXML
    private Label lblMemberNumber;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setTicketInfo(String combustible, String litros, String importe, String metodoPago, boolean isMember, String memberNumber) {
        lblCombustible.setText("Combustible: " + combustible);
        lblLitros.setText("Litros: " + litros);
        lblImporte.setText("Importe: " + importe);
        lblMetodoPago.setText("Método de pago: " + metodoPago);
        lblIsMember.setText("es miembro: "+ isMember);
        lblMemberNumber.setText("número de miembro: "+ memberNumber);

        try {
            crearArchivoTicket(combustible, litros, importe, metodoPago, memberNumber);
        } catch(IOException e) {
            e.printStackTrace();
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

    @FXML
    private void handleVolverEmpezar() throws Exception {

        main.showPantallaInicial();
    }
}
