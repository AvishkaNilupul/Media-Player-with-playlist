module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires java.desktop;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}