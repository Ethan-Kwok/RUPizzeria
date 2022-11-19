package com.example.rupizzeria;

import java.util.ArrayList;

public abstract class Pizza implements Customizable {

    private ArrayList<Toppings> toppingsArrayList;
    private Crust crust;
    private Size size;
    public abstract double price();

    public ArrayList<Toppings> getToppingsArrayList() {
        if (toppingsArrayList == null) toppingsArrayList = new ArrayList<>();
        return toppingsArrayList;
    }

    public void setToppingsArrayList(ArrayList<Toppings> newToppingsArrayList) {
        this.toppingsArrayList = newToppingsArrayList;
    }

    public Crust getCrust() {
        return this.crust;
    }

    public void setCrust(Crust newCrust) {
        this.crust = newCrust;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size newSize) {
        this.size = newSize;
    }

}
