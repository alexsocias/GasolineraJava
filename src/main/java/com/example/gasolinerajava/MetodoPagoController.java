package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MetodoPagoController {

    @FXML
    private Button btnEfectivo;

    @FXML
    private Button btnTarjeta;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleEfectivo() throws Exception {
        main.setMetodoPago("Efectivo");
        main.showIntroducirBilletes();
    }

    @FXML
    private void handleTarjeta() throws Exception {
        main.setMetodoPago("Tarjeta");
        main.showIntroducirDatosTarjeta();
    }

}
