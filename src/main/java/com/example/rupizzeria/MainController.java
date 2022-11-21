package com.example.rupizzeria;

import javafx.application.Application;
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

/**
 * Main View Controller Class. Represents the User Interface controller that processes user button presses in the UI
 * fields and calls the corresponding methods that opens the corresponding View. Maintains necessary information for
 * the transfer of information between classes.
 *
 * @author David Ma, Ethan Kwok
 */
public class MainController {
    @FXML
    private Button chicagoButton, nyButton, storeOrderButton, currentOrderButton;
    @FXML
    private ImageView chicagoStyleImage, nyStyleImage;

    private static StoreOrder myStoreOrder;
    private static Order myOrder;
    private static ArrayList<Integer> orderNumberArrayList;

    /**
     * Creates an orderNumberArrayList for tracking the order number. Creates a storeOrder and Order object.
     */
    public MainController() {
        orderNumberArrayList = new ArrayList<>();
        myStoreOrder = new StoreOrder();
        myOrder = new Order();
    }

    /**
     * Getter method to get the current order.
     * @return Order object representing the current order
     */
    public static Order getMyOrder() {
        return myOrder;
    }

    /**
     * Getter method to get the store order.
     * @return Order object representing the store order
     */
    public static StoreOrder getMyStoreOrder() {
        return myStoreOrder;
    }

    /**
     * Adds a pizza to the current order.
     * @param pizza Pizza object to be added to the current order.
     */
    public static void addToOrder(Pizza pizza) {
        myOrder.add(pizza);
    }

    /**
     * Creates the order number such that it is a unique number. Keeps track of this number in orderNumberArrayList.
     * @return int representing the order number.
     */
    public static int orderNumber() {
        int i = 1;
        while (orderNumberArrayList.contains(i)) i++;
        orderNumberArrayList.add(i);
        return i;
    }

    /**
     * Getter method that returns the total number of orders in the store order. Keeps track through the size of the
     * orderNumberArrayList.
     * @return int representing the number of orders in the store order.
     */
    public static ArrayList<Integer> getOrderNumArrayList() {
        return orderNumberArrayList;
    }

    /**
     * Creates and sets a new Order object for when an order is completed and a new one needs to be set.
     */
    public static void resetMyOrder() {
        myOrder = new Order();
    }

    /**
     * Adds an order to the list of store orders for when the order is completed.
     * @param order Order object to be added to the store orders.
     */
    public static void addToStoreOrder(Order order) {
        myStoreOrder.add(order);
    }

    /**
     * Loads and opens the ChicagoStyle pizza GUI.
     * @throws IOException
     */
    public void onChicagoButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ChicagoStyleView.fxml"));
        Parent MainPage = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Chicago Style Pizza");
        stage.setScene(new Scene(MainPage, 600, 432));
        stage.show();
    }

    /**
     * Loads and opens the NewYorkStyle pizza GUI.
     * @throws IOException
     */
    public void onNewYorkButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("NewYorkStyleView.fxml"));
        Parent MainPage = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("New York Style Pizza");
        stage.setScene(new Scene(MainPage, 600, 432));
        stage.show();

    }

    /**
     * Loads and opens the StoreOrder GUI that keeps track of all the total store orders.
     * @throws IOException
     */
    public void onStoreOrderButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("StoreOrderView.fxml"));
        Parent MainPage = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Store Order");
        stage.setScene(new Scene(MainPage, 626, 454));
        stage.show();
    }

    /**
     * Loads and opens the CurrentOrder GUI that keeps track of the pizzas and price in the current order.
     * @throws IOException
     */
    public void onCurrentOrderButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("CurrentOrderView.fxml"));
        Parent MainPage = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Current Order");
        stage.setScene(new Scene(MainPage, 661, 600));
        stage.show();
    }

}