package com.example.rupizzeria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StoreOrderController implements Initializable {

    @FXML
    private Label orderTotalLabel;
    @FXML
    private ListView<String> orderList;
    @FXML
    private Button cancelOrderButton, exportButton;
    @FXML
    private ComboBox orderComboBox = new ComboBox();

    private StoreOrder myStoreOrder;
    private String[] orderNumberList;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final int STARTING_ORDER_NUMBER = 1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderComboBox.getItems().addAll(orderNumberList);
        orderComboBox.setValue("1");

        if(myStoreOrder.getStoreOrder() != null) {
            Order startingOrder = null;
            for(Order o : myStoreOrder.getStoreOrder()) {
                if(o.getOrderNumber() == STARTING_ORDER_NUMBER) {
                    startingOrder = o;
                }
            }
            if (startingOrder != null) {
                for (Pizza p : startingOrder.getOrder()) {
                    orderList.getItems().add(CurrentOrderController.toString(p));
                }
                orderTotalLabel.setText(df.format(CurrentOrderController.totalPrice(startingOrder)));
            }
        }
    }

    public StoreOrderController() {
        if(MainController.getNumOrders() != 1) {
            orderNumberList = new String[MainController.getNumOrders() - 1];
            for(int i = 0; i < orderNumberList.length; i++) {
                orderNumberList[i] = "" + (i + 1);
            }
        }
        else {
            orderNumberList = new String[STARTING_ORDER_NUMBER];
            orderNumberList[0] = "" + STARTING_ORDER_NUMBER;
        }
        myStoreOrder = MainController.getMyStoreOrder();
    }

    public void displayOrder(ActionEvent event) {
        int orderNum = Integer.parseInt(orderComboBox.getValue().toString());
        Order orderToDisplay = null;
        for(Order o : myStoreOrder.getStoreOrder()) {
            if(o.getOrderNumber() == orderNum) {
                orderToDisplay = o;
            }
        }
        if(orderToDisplay != null) {
            orderList.getItems().clear();
            for (Pizza p : orderToDisplay.getOrder()) {
                orderList.getItems().add(CurrentOrderController.toString(p));
            }
            orderTotalLabel.setText(df.format(CurrentOrderController.totalPrice(orderToDisplay)));
        }
    }
}
