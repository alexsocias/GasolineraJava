package com.example.gasolinerajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class LoginController {

    @FXML
    private RadioButton siSocioRadioButton;

    @FXML
    private RadioButton noSocioRadioButton;

    @FXML
    private TextField numeroSocioTextField;

    @FXML
    private Button loginButton;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void initialize() {
        ToggleGroup group = new ToggleGroup();
        siSocioRadioButton.setToggleGroup(group);
        noSocioRadioButton.setToggleGroup(group);

        numeroSocioTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (siSocioRadioButton.isSelected() && !newValue.trim().isEmpty()) {
                loginButton.setDisable(false);
            } else {
                loginButton.setDisable(true);
            }
        });

        loginButton.setOnAction(e -> {
            // Código para manejar la acción de inicio de sesión
            try {
                if (siSocioRadioButton.isSelected()) {
                    main.setIsMember(true);  // Establecer el valor de socio en verdadero
                    main.setMemberNumber(numeroSocioTextField.getText());  // Obtener y establecer el número de socio ingresado
                } else {
                    main.setIsMember(false);  // Establecer el valor de socio en falso
                    main.setMemberNumber("");  // Establecer el número de socio vacío
                }
                main.showPantallaInicial();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        noSocioRadioButton.setOnAction(e -> {
            // Código para manejar la selección de "No Socio"
            loginButton.setDisable(false);  // Habilitar el botón Login
        });

        siSocioRadioButton.setOnAction(e -> {
            // Código para manejar la selección de "Sí Socio"
            if (!numeroSocioTextField.getText().trim().isEmpty()) {
                loginButton.setDisable(false);  // Habilitar el botón Login
            } else {
                loginButton.setDisable(true);  // Deshabilitar el botón Login
            }
        });
    }
}

