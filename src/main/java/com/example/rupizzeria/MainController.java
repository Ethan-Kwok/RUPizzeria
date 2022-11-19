package com.example.rupizzeria;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {
    @FXML
    private Button chicagoButton, currentOrderButton;
    @FXML
    private ImageView chicagoStyleImage;

    private static StoreOrder myStoreOrder;

    private static Order myOrder;

    public MainController() {
        myStoreOrder = new StoreOrder();
        myOrder = new Order();
    }

    public static Order getMyOrder() {
        return myOrder;
    }

    public static void addToOrder(Pizza pizza) {
        myOrder.add(pizza);
    }

    public static void addStringToOrder(String string) {
        myOrder.addString(string);
    }

    public static void resetMyOrder() {
        myOrder = new Order();
    }

    public static void addToStoreOrder(Order order) {
        myStoreOrder.add(order);
    }

    public void onChicagoButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ChicagoStyleView.fxml"));
        Parent MainPage = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Chicago Style Pizza");
        stage.setScene(new Scene(MainPage, 900, 600));
        stage.show();
    }

    public void onCurrentOrderButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("CurrentOrderView.fxml"));
        Parent MainPage = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Current Order");
        stage.setScene(new Scene(MainPage, 900, 600));
        stage.show();
    }

}