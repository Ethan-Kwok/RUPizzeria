package com.example.rupizzeria;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Order implements Customizable {

    private ArrayList<Pizza> myOrder;
    private int orderNumber;

    public Order() {
        myOrder = new ArrayList<>();
        orderNumber = MainController.orderNumber();
    }

    public boolean add(Object obj) {
        if (obj instanceof Pizza) {
            Pizza newPizza = (Pizza) obj;
            myOrder.add(newPizza);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        if (obj instanceof Pizza) {
            Pizza newPizza = (Pizza) obj;
            if (myOrder.remove(newPizza)) return true;
        }
        return false;
    }

    public ArrayList<Pizza> getOrder() {
        return this.myOrder;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

}
