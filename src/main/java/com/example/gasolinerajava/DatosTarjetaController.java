package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleConfirmar() throws Exception {

        String numeroTarjeta = txtNumeroTarjeta.getText();
        String fechaVencimiento = txtFechaVencimiento.getText();
        String codigoSeguridad = txtCodigoSeguridad.getText();

        if (validarDatosTarjeta(numeroTarjeta, fechaVencimiento, codigoSeguridad)) {
            main.showTicket();
        } else {
            // Mostrar un mensaje de error o una alerta
        }
    }

    private boolean validarDatosTarjeta(String numeroTarjeta, String fechaVencimiento, String codigoSeguridad) {
        // Implementa la validación de los datos de la tarjeta aquí
        // Retorna true si los datos son válidos, de lo contrario, retorna false
        return true;
    }
}
