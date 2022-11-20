package com.example.rupizzeria;

import java.util.ArrayList;

public class StoreOrder implements Customizable {

    private ArrayList<Order> myStoreOrder;

    public StoreOrder() {
        myStoreOrder = new ArrayList<>();
    }

    public boolean add(Object obj) {
        if (obj instanceof Order) {
            Order newOrder = (Order) obj;
            myStoreOrder.add(newOrder);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            Order newOrder = (Order) obj;
            if (myStoreOrder.remove(newOrder))
                return true;
        }
        return false;
    }

    public void export() {

    }

    public ArrayList<Order> getStoreOrder() {
        return this.myStoreOrder;
    }

}
