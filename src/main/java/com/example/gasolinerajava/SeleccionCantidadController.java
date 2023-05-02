package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SeleccionCantidadController {

    @FXML
    private Button btn5;

    @FXML
    private Button btn10;

    @FXML
    private Button btn15;

    @FXML
    private Button btn20;

    @FXML
    private Button btn50;

    @FXML
    private Button btn100;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handle5() throws Exception {
        handleCantidad(5);
    }

    @FXML
    private void handle10() throws Exception {
        handleCantidad(10);
    }

    @FXML
    private void handle15() throws Exception {
        handleCantidad(15);
    }

    @FXML
    private void handle20() throws Exception {
        handleCantidad(20);
    }

    @FXML
    private void handle50() throws Exception {
        handleCantidad(50);
    }

    @FXML
    private void handle100() throws Exception {
        handleCantidad(100);
    }

    private void handleCantidad(int cantidad) throws Exception {
        main.showPantallaMetodoPago();
    }
}
