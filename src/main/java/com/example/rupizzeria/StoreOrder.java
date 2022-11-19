package com.example.rupizzeria;

import java.util.ArrayList;

public class StoreOrder implements Customizable {

    private ArrayList<Order> myStoreOrder;

    private int orderNumber;

    public StoreOrder() {
        myStoreOrder = new ArrayList<>();
        orderNumber = 1;
    }
/*
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int newNumber) {
        this.orderNumber = newNumber;
    }*/

    public boolean add(Object obj) {
        if (obj instanceof Order) {
            Order newOrder = (Order) obj;
            myStoreOrder.add(newOrder);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        //TODO
        return false;
    }

    public void export() {

    }

}
