package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SeleccionCombustibleController {
    @FXML
    private Button btnGasolina;

    @FXML
    private Button btnDiesel;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleGasolina() throws Exception {

        main.showPantallaCantidad();
    }

    @FXML
    private void handleDiesel() throws Exception {

        main.showPantallaCantidad();
    }
}
