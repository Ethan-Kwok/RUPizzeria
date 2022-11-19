package com.example.rupizzeria;

public class ChicagoPizza implements PizzaFactory {

    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.add(Toppings.valueOf("SAUSAGE"));
        pizza.add(Toppings.valueOf("PEPPERONI"));
        pizza.add(Toppings.valueOf("GREEN_PEPPER"));
        pizza.add(Toppings.valueOf("ONION"));
        pizza.add(Toppings.valueOf("MUSHROOM"));
        pizza.setCrust(Crust.valueOf("DEEP_DISH"));
        return pizza;
    }

    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.add(Toppings.valueOf("SAUSAGE"));
        pizza.add(Toppings.valueOf("PEPPERONI"));
        pizza.add(Toppings.valueOf("BEEF"));
        pizza.add(Toppings.valueOf("HAM"));
        pizza.setCrust(Crust.valueOf("STUFFED"));
        return pizza;
    }

    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.add(Toppings.valueOf("BBQ_CHICKEN"));
        pizza.add(Toppings.valueOf("GREEN_PEPPER"));
        pizza.add(Toppings.valueOf("PROVOLONE"));
        pizza.add(Toppings.valueOf("CHEDDAR"));
        pizza.setCrust(Crust.valueOf("PAN"));
        return pizza;
    }

    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.valueOf("PAN"));
        return pizza;
    }

}
