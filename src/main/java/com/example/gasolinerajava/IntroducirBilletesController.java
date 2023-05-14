package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class IntroducirBilletesController {

    @FXML
    private TextField txtBilletes;

    @FXML
    private Button btnAceptarBilletes;

    @FXML
    private Label lblError;

    private Main main;
    private int totalPagar;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    @FXML
    public void initialize() {
        txtBilletes.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                lblError.setText("");
            }
        });
    }

    @FXML
    private void handleAceptarBilletes() {
        try {
            int billetes = Integer.parseInt(txtBilletes.getText());

            if (billetes == Integer.parseInt(main.getLitros())) {
                lblError.setText("");
                main.showGraciasCompra();
            } else {
                lblError.setText("El importe introducido no coincide con el importe a pagar.");
            }
        } catch(NumberFormatException e) {
            lblError.setText("Por favor, introduzca un número válido.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
