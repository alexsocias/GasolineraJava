package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setTicketInfo(String combustible, String litros, String importe, String metodoPago) {
        lblCombustible.setText("Combustible: " + combustible);
        lblLitros.setText("Litros: " + litros);
        lblImporte.setText("Importe: " + importe);
        lblMetodoPago.setText("Método de pago: " + metodoPago);
    }

    @FXML
    private void handleVolverEmpezar() throws Exception {
        // Realiza la acción correspondiente cuando se presiona el botón Volver a empezar
        // Por ejemplo, mostrar la pantalla inicial del proceso de compra
        main.showPantallaInicial();
    }
}
