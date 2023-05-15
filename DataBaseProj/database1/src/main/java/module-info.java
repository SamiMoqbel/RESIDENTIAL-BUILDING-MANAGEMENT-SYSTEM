module com.example.database1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.database1 to javafx.fxml;
    exports com.example.database1;
}