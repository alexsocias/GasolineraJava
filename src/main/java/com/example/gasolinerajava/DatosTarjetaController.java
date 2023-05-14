package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DatosTarjetaController {

    @FXML
    private TextField txtNumeroTarjeta;

    @FXML
    private TextField txtFechaVencimiento;

    @FXML
    private TextField txtCodigoSeguridad;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Label lblError;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleConfirmar() throws Exception {
        String numeroTarjeta = txtNumeroTarjeta.getText();
        String fechaVencimiento = txtFechaVencimiento.getText();
        String codigoSeguridad = txtCodigoSeguridad.getText();

        try {
            if (validarDatosTarjeta(numeroTarjeta, fechaVencimiento, codigoSeguridad)) {
                main.showTicket();
            } else {
                lblError.setText("Los datos de la tarjeta son inválidos");
            }
        } catch (Exception e) {
            lblError.setText("Error al validar los datos de la tarjeta");
        }
    }

    private boolean validarDatosTarjeta(String numeroTarjeta, String fechaVencimiento, String codigoSeguridad) throws Exception {
        // Retorna true si los datos son válidos, de lo contrario, retorna false
        if (numeroTarjeta.length() != 16 || fechaVencimiento.isEmpty()|| codigoSeguridad.length() != 3) {
            return false;
        }

        return true;
    }
}
