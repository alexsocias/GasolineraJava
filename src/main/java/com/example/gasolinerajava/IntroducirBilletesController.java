package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class IntroducirBilletesController {

    @FXML
    private TextField txtBilletes;

    @FXML
    private Button btnAceptarBilletes;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleAceptarBilletes() throws Exception {
        int billetes = Integer.parseInt(txtBilletes.getText());
        main.showGraciasCompra();
    }
}
