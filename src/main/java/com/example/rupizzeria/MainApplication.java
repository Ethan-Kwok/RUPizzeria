package com.example.rupizzeria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * RU Pizzeria Main User Interface application class that creates the main UI and runs it with the appropriate size
 * and title.
 *
 * @author David Ma, Ethan Kwok
 */
public class MainApplication extends Application {
    /**
     * Start function that loads the Main FXML view file and prepares the UI. Sets the stage that displays the JavaFX window.
     *
     * @param stage top-level JavaFX container window for the JavaFX output.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main function that launches the UI.
     *
     * @param args argument function used in running main functions.
     */
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