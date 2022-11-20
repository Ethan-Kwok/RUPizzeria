package com.example.rupizzeria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class CurrentOrderController implements Initializable {

    @FXML
    private ListView<String> pizzaList;
    @FXML
    private Button finishOrderButton, removeOrderButton, clearOrderButton;
    @FXML
    private Label orderLabel;

    private Order myOrder;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final Crust[] ChicagoStyleCrusts = {Crust.valueOf("DEEP_DISH"), Crust.valueOf("PAN"),
            Crust.valueOf("STUFFED")};
    private static final Crust[] NewYorkStyleCrusts = {Crust.valueOf("BROOKLYN"), Crust.valueOf("THIN"),
            Crust.valueOf("HAND_TOSSED")};

    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (myOrder != null) {
            for (Pizza p : myOrder.getOrder()) {
                pizzaList.getItems().add(toString(p));
            }
        }
    }

    public CurrentOrderController() {
        myOrder = MainController.getMyOrder();
    }

    public String toString(Pizza pizza) {
        String output = "";
        if (pizza instanceof Deluxe) output += "DELUXE";
        if (pizza instanceof BBQChicken) output += "BBQ CHICKEN";
        if (pizza instanceof Meatzza) output += "MEATZZA";
        if (pizza instanceof BuildYourOwn) output += "BUILD YOUR OWN";
        if (isChicagoStyle(pizza.getCrust())) output += " (CHICAGO STYLE - ";
        else output += "NEW YORK STYLE - ";
        output += pizza.getCrust() + "), ";
        for (Toppings t : pizza.getToppingsArrayList()) {
            output += t.toString() + ", ";
        }
        output += pizza.getSize() + ": $" + df.format(pizza.price());
        return output;
    }

    private boolean isChicagoStyle(Crust crust) {
        for (Crust c : ChicagoStyleCrusts) {
            if (c.equals(crust)) return true;
        }
        return false;
    }

    public boolean removeOrder(ActionEvent event) {
        try {
            int selectedIndex = pizzaList.getSelectionModel().getSelectedIndex();
            if (myOrder.remove(myOrder.getOrder().get(selectedIndex))) pizzaList.getItems().remove(
                    pizzaList.getSelectionModel().getSelectedIndex());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clearOrder(ActionEvent event) {
        try {
            for (Pizza p : myOrder.getOrder()) {
                myOrder.remove(p);
                pizzaList.getItems().clear();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void finishOrder() {
        if (myOrder.getSize() <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Cannot place an empty order");
            alert.setTitle("ERROR");
            alert.setHeaderText(null);

            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Order Placed");
        alert.setTitle("SUCCESS");
        alert.setHeaderText(null);

        MainController.addToStoreOrder(this.myOrder);
        MainController.resetMyOrder();

        alert.showAndWait();
        Stage stage = (Stage) finishOrderButton.getScene().getWindow();
        stage.close();

    }

}
