package com.example.rupizzeria;

import java.util.ArrayList;

public class BBQChicken extends Pizza {

    public double price() {
        double price = this.getSize().getBBQChicken();
        return price;
    }

    public boolean add(Object obj) {
        if (obj instanceof Toppings) {
            Toppings newTopping = (Toppings) obj;
            ArrayList<Toppings> toppingList = getToppingsArrayList();
            if (toppingList.contains(newTopping)) return false;
            toppingList.add(newTopping);
            setToppingsArrayList(toppingList);
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        if (obj instanceof Toppings) {
            Toppings newTopping = (Toppings) obj;
            ArrayList<Toppings> toppingList = getToppingsArrayList();
            if (toppingList.remove(newTopping)) {
                setToppingsArrayList(toppingList);
                return true;
            }
        }
        return false;
    }

}
