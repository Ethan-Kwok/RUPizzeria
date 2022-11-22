module com.example.rupizzeria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires junit;
    requires org.junit.jupiter.api;


    opens com.example.rupizzeria to javafx.fxml;
    exports com.example.rupizzeria;
    exports junittestclasses;
    opens junittestclasses to javafx.fxml;
}