module com.example.gasolinerajava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.gasolinerajava to javafx.fxml;
    exports com.example.gasolinerajava;
}