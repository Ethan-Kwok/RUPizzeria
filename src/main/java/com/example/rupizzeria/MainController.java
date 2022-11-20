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
import java.util.ArrayList;

public class MainController {
    @FXML
    private Button chicagoButton, nyButton, storeOrderButton, currentOrderButton;
    @FXML
    private ImageView chicagoStyleImage, nyStyleImage;

    private static StoreOrder myStoreOrder;
    private static Order myOrder;
    private static ArrayList<Integer> orderNumberArrayList;

    public MainController() {
        orderNumberArrayList = new ArrayList<>();
        myStoreOrder = new StoreOrder();
        myOrder = new Order();
    }

    public static Order getMyOrder() {
        return myOrder;
    }

    public static StoreOrder getMyStoreOrder() {
        return myStoreOrder;
    }

    public static void addToOrder(Pizza pizza) {
        myOrder.add(pizza);
    }

    public static int orderNumber() {
        int i = 1;
        while (orderNumberArrayList.contains(i)) i++;
        orderNumberArrayList.add(i);
        return i;
    }

    public static int getNumOrders() {
        return orderNumberArrayList.size();
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
        stage.setScene(new Scene(MainPage, 600, 432));
        stage.show();
    }

    public void onNewYorkButtonClick(ActionEvent event) throws IOException {}

    public void onStoreOrderButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("StoreOrderView.fxml"));
        Parent MainPage = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Store Order");
        stage.setScene(new Scene(MainPage, 900, 600));
        stage.show();
    }

    public void onCurrentOrderButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("CurrentOrderView.fxml"));
        Parent MainPage = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Current Order");
        stage.setScene(new Scene(MainPage, 661, 600));
        stage.show();
    }

}