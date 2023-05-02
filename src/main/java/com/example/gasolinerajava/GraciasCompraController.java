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
        // Realiza la acción correspondiente cuando se presiona el botón Ticket
        // Por ejemplo, imprimir el ticket de compra o mostrarlo en una ventana emergente
        imprimirTicket();
    }

    @FXML
    private void handleVolverEmpezar() throws Exception {
        // Realiza la acción correspondiente cuando se presiona el botón Volver a empezar
        // Por ejemplo, mostrar la pantalla inicial del proceso de compra
        main.showPantallaInicial();
    }

    private void imprimirTicket() throws Exception {
        main.showTicket();
    }
}
