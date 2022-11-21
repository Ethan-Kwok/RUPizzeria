package com.example.rupizzeria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
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
        orderComboBox.getItems().addAll(MainController.getOrderNumArrayList());
        if(!(MainController.getOrderNumArrayList().size() <= STARTING_ORDER_NUMBER)) {
            int numOrders = MainController.getOrderNumArrayList().size() - 1;
            orderComboBox.getItems().remove(MainController.getOrderNumArrayList().get(numOrders));
        }
        orderComboBox.setValue(MainController.getOrderNumArrayList().get(0));

        if(myStoreOrder.getStoreOrder() != null) {
            Order startingOrder = null;
            for(Order o : myStoreOrder.getStoreOrder()) {
                if(o.getOrderNumber() == MainController.getOrderNumArrayList().get(0)) {
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
        myStoreOrder = MainController.getMyStoreOrder();
    }

    public void displayOrder(ActionEvent event) {
        if(orderComboBox.getValue() == null) {
            return;
        }

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

    public boolean cancelOrder(ActionEvent event) {
        try {
            int orderNum = Integer.parseInt(orderComboBox.getValue().toString());
            Order orderToCancel = null;
            for(Order o : myStoreOrder.getStoreOrder()) {
                if(o.getOrderNumber() == orderNum) {
                    orderToCancel = o;
                }
            }
            if(myStoreOrder.remove(orderToCancel)) {
                int removeIndex = MainController.getOrderNumArrayList().indexOf(orderNum);
                orderComboBox.getItems().remove(MainController.getOrderNumArrayList().get(removeIndex));

                if(orderNum == MainController.getOrderNumArrayList().get(0)) {
                    if(MainController.getOrderNumArrayList().get(++removeIndex) != null) {
                        orderComboBox.setValue(MainController.getOrderNumArrayList().get(removeIndex));
                    }
                }
                MainController.getOrderNumArrayList().remove(Integer.valueOf(orderNum));
                orderNum = Integer.parseInt(orderComboBox.getValue().toString());

                Order orderToDisplay = null;
                for(Order o : myStoreOrder.getStoreOrder()) {
                    if(o.getOrderNumber() == orderNum) {
                        orderToDisplay = o;
                    }
                }
                orderTotalLabel.setText(df.format(CurrentOrderController.totalPrice(orderToDisplay)));
            }
            return true;
        }
        catch(Exception e) {
            orderTotalLabel.setText("0.00");
            return false;
        }
    }

    public void export(ActionEvent event) throws IOException {
        myStoreOrder.export();
    }
}
