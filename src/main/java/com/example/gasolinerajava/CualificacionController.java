package com.example.gasolinerajava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CualificacionController {

    @FXML
    private Slider slider;
    @FXML
    private Button btnValoracion;

    private Main main; // Añadimos una instancia de Main

    // Método para configurar la instancia de Main
    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleValoracion(ActionEvent event) throws Exception {
        double rating = slider.getValue();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Gracias por tu valoración");
        alert.setHeaderText(null);
        alert.setContentText("Has valorado el servicio con un " + rating);
        alert.showAndWait();

        // Después de mostrar la calificación, vamos a la pantalla de agradecimiento
        try {
            main.showGraciasCompra(); // Aquí es donde cambié el método que se llama
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
