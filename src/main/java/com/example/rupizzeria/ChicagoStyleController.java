package com.example.rupizzeria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChicagoStyleController implements Initializable {

    @FXML
    private RadioButton smallRadioButton, mediumRadioButton, largeRadioButton;
    @FXML
    private Label priceLabel, crustLabel;
    @FXML
    private ListView<Toppings> allToppingsList, addedToppingsList;
    @FXML
    private ComboBox flavorComboBox = new ComboBox();
    @FXML
    private Button addButton, removeButton, addToOrderButton;
    @FXML
    private ImageView pizzaImage;
    private String[] flavor = {"DELUXE", "MEATZZA", "BBQ CHICKEN", "BUILD YOUR OWN"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flavorComboBox.getItems().addAll(flavor);
        flavorComboBox.setValue("DELUXE");

        for (Toppings t : Toppings.values()) {
            allToppingsList.getItems().add(t);
        }
        for (Toppings t : myPizza.getToppingsArrayList()) {
            addedToppingsList.getItems().add(t);
        }

        addButton.setDisable(true);
        removeButton.setDisable(true);

        updatePrice();
        updateCrust();

        Image image = new Image(getClass().getResourceAsStream("/images/deluxe_chicago_pizza.png"));
        pizzaImage.setImage(image);
    }

    private PizzaFactory pizzaFactory;
    private Pizza myPizza;
    private Order myOrder;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final int MAX_TOPPINGS = 7;

    public ChicagoStyleController() {
        pizzaFactory = new ChicagoPizza();
        myPizza = pizzaFactory.createDeluxe();
        myPizza.setSize(Size.valueOf("SMALL"));
        //myOrder = MainController.getMyOrder();
    }

    public void getFlavor(ActionEvent event) {
        String flavor = flavorComboBox.getValue().toString();
        addButton.setDisable(true);
        removeButton.setDisable(true);
        if (flavor.equals("DELUXE")) {
            myPizza = pizzaFactory.createDeluxe();
            pizzaImage.setImage(new Image(getClass().
                    getResourceAsStream("/images/deluxe_chicago_pizza.png")));
        }
        if (flavor.equals("MEATZZA")) {
            myPizza = pizzaFactory.createMeatzza();
            pizzaImage.setImage(new Image(getClass().
                    getResourceAsStream("/images/chicago_meatzza.png")));
        }
        if (flavor.equals("BBQ CHICKEN")) {
            myPizza = pizzaFactory.createBBQChicken();
            pizzaImage.setImage(new Image(getClass().
                    getResourceAsStream("/images/chicago_bbq.png")));
        }
        if (flavor.equals("BUILD YOUR OWN")) {
            myPizza = pizzaFactory.createBuildYourOwn();
            addButton.setDisable(false);
            removeButton.setDisable(false);
            pizzaImage.setImage(new Image(getClass().
                    getResourceAsStream("/images/chicago_style_with_toppings.png")));
        }

        addedToppingsList.getItems().clear();
        for (Toppings t : myPizza.getToppingsArrayList()) {
            addedToppingsList.getItems().add(t);
        }
        updateSize();
        updateCrust();
    }

    public void addTopping(ActionEvent event) {
        Toppings selectedTopping = allToppingsList.getSelectionModel().getSelectedItem();
        if (myPizza.add(selectedTopping)) addedToppingsList.getItems().add(selectedTopping);
        if (myPizza.getToppingsArrayList().size() >= MAX_TOPPINGS) {
            addButton.setDisable(true);
        }
        updatePrice();
    }

    public void removeTopping(ActionEvent event) {
        Toppings selectedTopping = addedToppingsList.getSelectionModel().getSelectedItem();
        if (myPizza.remove(selectedTopping)) addedToppingsList.getItems().remove(selectedTopping);
        if (myPizza.getToppingsArrayList().size() < MAX_TOPPINGS) {
            addButton.setDisable(false);
        }
        updatePrice();
    }

    public void addToOrder(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Pizza added to order");
        alert.setTitle("SUCCESS");
        alert.setHeaderText(null);

        MainController.addToOrder(myPizza);

        alert.showAndWait();
        Stage stage = (Stage) addToOrderButton.getScene().getWindow();
        stage.close();
    }

    public void updateSize() {
        if (smallRadioButton.isSelected()) myPizza.setSize(Size.valueOf("SMALL"));
        if (mediumRadioButton.isSelected()) myPizza.setSize(Size.valueOf("MEDIUM"));
        if (largeRadioButton.isSelected()) myPizza.setSize(Size.valueOf("LARGE"));
        updatePrice();
    }

    public void updatePrice() {
        String priceString = df.format(myPizza.price());
        priceLabel.setText(priceString);
    }

    public void updateCrust() {
        String crustString = myPizza.getCrust().toString();
        crustLabel.setText(crustString);
    }

}
