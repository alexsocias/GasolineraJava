package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GraciasCompraController {

    @FXML
    private Button btnTicket;

    @FXML
    private Button btnVolverEmpezar;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleTicket() throws Exception {

        imprimirTicket();
    }

    @FXML
    private void handleVolverEmpezar() throws Exception {

        main.showLoginScreen();
    }

    private void imprimirTicket() throws Exception {
        main.showTicket();
    }
}
