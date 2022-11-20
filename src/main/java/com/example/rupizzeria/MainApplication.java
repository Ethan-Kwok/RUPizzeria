package com.example.rupizzeria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        scene.getStylesheets().add(getClass().getResource("/fontStyle.css").toExternalForm());
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


/*

To do:
- subtotal and sales tax calculation under current order
- track unique order number (serial number) of orders and display under current order

- store order list display thing (basically everything)
- store order export() method
- store order cancel order method
- JUnit test
- javadoc
- class diagram
- make it look nice lol

 */