module com.example.gasolinerajava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gasolinerajava to javafx.fxml;
    exports com.example.gasolinerajava;
}