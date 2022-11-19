package com.example.rupizzeria;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {

    private static final double TOPPING_PRICE = 1.59;

    public double price() {
        double price = this.getSize().getBuildYourOwn();
        price += TOPPING_PRICE * getToppingsArrayList().size();
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
