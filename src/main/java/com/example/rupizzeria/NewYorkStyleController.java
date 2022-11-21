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

/**
 * NewYorkStyleController Class that is the User Interface Controller class for New York Style Pizzas. Allows the user
 * to choose the flavor of the pizza and the size. If the pizza is a build-your-own, it allows the user to add or remove
 * toppings. Displays the toppings on the pizza, the crust, and an image of the pizza. Keeps track of and displays the
 * price of the pizza.
 *
 * @author David Ma, Ethan Kwok
 */
public class NewYorkStyleController implements Initializable {

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
    private final String[] flavor = {"DELUXE", "MEATZZA", "BBQ CHICKEN", "BUILD YOUR OWN"};

    /**
     * Initialize function used to set up the GUI. Defines the values in the flavor ComboBox, as well as the
     * toppings in the listview. Sets the price, crust, image, and pizza to default values.
     * @param url
     * @param resourceBundle
     */
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

        Image image = new Image(getClass().getResourceAsStream("/images/deluxe_ny_pizza.png"));
        pizzaImage.setImage(image);
    }

    private PizzaFactory pizzaFactory;
    private Pizza myPizza;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final int MAX_TOPPINGS = 7;

    /**
     * Constructor that creates a New York Pizza with default values of SMALL DELUXE.
     */
    public NewYorkStyleController() {
        pizzaFactory = new NewYorkPizza();
        myPizza = pizzaFactory.createDeluxe();
        myPizza.setSize(Size.valueOf("SMALL"));
    }

    /**
     * Changes the flavor of the Pizza to match the ComboBox. Changes the image to match the new flavor, and
     * calls the methods to update the size price and crust.
     */
    public void getFlavor() {
        String flavor = flavorComboBox.getValue().toString();
        addButton.setDisable(true);
        removeButton.setDisable(true);
        if (flavor.equals("DELUXE")) {
            myPizza = pizzaFactory.createDeluxe();
            pizzaImage.setImage(new Image(getClass().
                    getResourceAsStream("/images/deluxe_ny_pizza.png")));
        }
        if (flavor.equals("MEATZZA")) {
            myPizza = pizzaFactory.createMeatzza();
            pizzaImage.setImage(new Image(getClass().
                    getResourceAsStream("/images/ny_meatzza.png")));
        }
        if (flavor.equals("BBQ CHICKEN")) {
            myPizza = pizzaFactory.createBBQChicken();
            pizzaImage.setImage(new Image(getClass().
                    getResourceAsStream("/images/ny_bbq.png")));
        }
        if (flavor.equals("BUILD YOUR OWN")) {
            myPizza = pizzaFactory.createBuildYourOwn();
            addButton.setDisable(false);
            removeButton.setDisable(false);
            pizzaImage.setImage(new Image(getClass().
                    getResourceAsStream("/images/ny_pizza_with_toppings.png")));
        }

        addedToppingsList.getItems().clear();
        for (Toppings t : myPizza.getToppingsArrayList()) {
            addedToppingsList.getItems().add(t);
        }
        updateSize();
        updateCrust();
    }

    /**
     * Adds the selected topping onto the Pizza if applicable and displays the newly added topping.
     * @return true if the topping is successfully added, false if there is an exception.
     */
    public boolean addTopping() {
        try {
            Toppings selectedTopping = allToppingsList.getSelectionModel().getSelectedItem();
            if (myPizza.add(selectedTopping)) addedToppingsList.getItems().add(selectedTopping);
            if (myPizza.getToppingsArrayList().size() >= MAX_TOPPINGS) {
                addButton.setDisable(true);
            }
            updatePrice();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Removes the selected topping from the Pizza if applicable and removes the topping from the list of toppings.
     * @return true if the topping is successfully removed, false if there is an exception.
     */
    public boolean removeTopping() {
        try {
            Toppings selectedTopping = addedToppingsList.getSelectionModel().getSelectedItem();
            if (myPizza.remove(selectedTopping)) addedToppingsList.getItems().remove(selectedTopping);
            if (myPizza.getToppingsArrayList().size() < MAX_TOPPINGS) {
                addButton.setDisable(false);
            }
            updatePrice();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Adds the Pizza to the current order, alerts the user, and then closes the window.
     */
    public void addToOrder() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Pizza added to order");
        alert.setTitle("SUCCESS");
        alert.setHeaderText(null);

        MainController.addToOrder(myPizza);

        alert.showAndWait();
        Stage stage = (Stage) addToOrderButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Changes the size of the Pizza to match the radio buttons. It then calls the method to update the price.
     */
    public void updateSize() {
        if (smallRadioButton.isSelected()) myPizza.setSize(Size.valueOf("SMALL"));
        if (mediumRadioButton.isSelected()) myPizza.setSize(Size.valueOf("MEDIUM"));
        if (largeRadioButton.isSelected()) myPizza.setSize(Size.valueOf("LARGE"));
        updatePrice();
    }

    /**
     * Finds the price of the Pizza and displays it in the appropriate decimal format.
     */
    public void updatePrice() {
        String priceString = df.format(myPizza.price());
        priceLabel.setText(priceString);
    }

    /**
     * Finds the crust of the Pizza and displays it.
     */
    public void updateCrust() {
        String crustString = myPizza.getCrust().toString();
        crustLabel.setText(crustString);
    }

}
