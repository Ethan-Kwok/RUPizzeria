package com.example.rupizzeria;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentOrderController implements Initializable {

    @FXML
    private ListView<Pizza> pizzaList;
    @FXML
    private Button finishOrderButton;

    private Order myOrder;

    private static final Crust[] ChicagoStyleCrusts = {Crust.valueOf("DEEP_DISH"), Crust.valueOf("PAN"),
            Crust.valueOf("STUFFED")};
    private static final Crust[] NewYorkStyleCrusts = {Crust.valueOf("BROOKLYN"), Crust.valueOf("THIN"),
            Crust.valueOf("HAND_TOSSED")};

    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (myOrder != null) {
            for (Pizza p : myOrder.getOrder()) {
                pizzaList.getItems().add(p); //MAKE THIS STRING BY IMPLEMENTING TOSTRING METHOD
            }
        }
    }

    public CurrentOrderController() {
        myOrder = MainController.getMyOrder();
    }

    @Override
    public String toString(Pizza pizza) {
        String output = "";
        if (pizza instanceof Deluxe) output += "DELUXE";
        if (pizza instanceof BBQChicken) output += "BBQ CHICKEN";
        if (pizza instanceof Meatzza) output += "MEATZZA";
        if (pizza instanceof BuildYourOwn) output += "BUILD YOUR OWN";
        if (ChicagoStyleCrusts.contains)

        String output = flavor.toString() + " (CHICAGO STYLE - " + myPizza.getCrust() + "), ";
        for (Toppings t : myPizza.getToppingsArrayList()) {
            output += t.toString() + ", ";
        }
        output += df.format(myPizza.price());
        return output;
    }

    private boolean containsValue(Crust crust) {
        for (Crust c : )
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
