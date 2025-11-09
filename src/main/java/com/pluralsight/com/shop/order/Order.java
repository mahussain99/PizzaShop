package com.pluralsight.com.shop.order;
import com.pluralsight.com.shop.drinks.Drink;
import com.pluralsight.com.shop.products.GarlicKnots;
import com.pluralsight.com.shop.products.Pizza;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    private String orderID;
    private ArrayList<Pizza> pizzas;
    private ArrayList<Drink> drinks;
    private GarlicKnots garlicKnots;
    private LocalDateTime dateTime;

    public Order(String orderID, GarlicKnots garlicKnots, LocalDateTime dateTime) {
        this.orderID = orderID;
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = null;
        this.dateTime = LocalDateTime.now();
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public GarlicKnots getGarlicKnots() {
        return garlicKnots;
    }

    public void setGarlicKnots(GarlicKnots garlicKnots) {
        this.garlicKnots = garlicKnots;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // Adding each item in the list

    public void addPizza(Pizza piz) {
        pizzas.add(piz);
    }

    public void addDrinks(Drink dk) {
        drinks.add(dk);
    }

    public void addGarlicNots(GarlicKnots gK) {
        this.garlicKnots = garlicKnots;
    }
    // Cal.. total amount of order

    public double getTotal() {
        double total = 0;

        // list pizza price

        for (Pizza piz : pizzas) {
            total += piz.getPrice();
        }

        for (Drink dk: drinks) {
            total += dk.getPrice();
        }

        if (garlicKnots != null){
            total += garlicKnots.getPrice();
        }
        return total; // just for understanding
    }
}



