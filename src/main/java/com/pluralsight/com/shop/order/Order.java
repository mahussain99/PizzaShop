package com.pluralsight.com.shop.order;
import com.pluralsight.com.shop.drinks.Drink;
import com.pluralsight.com.shop.products.GarlicKnots;
import com.pluralsight.com.shop.products.Pizza;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    private String orderID;
    private ArrayList <Pizza> pizzas;
    private ArrayList <Drink> drinks;
    private GarlicKnots garlicKnots;
    private LocalDateTime dateTime;

    public Order(String orderID, GarlicKnots garlicKnots, LocalDateTime dateTime) {
        this.orderID = orderID;
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = garlicKnots;
        this.dateTime = LocalDateTime.now();
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

    // Adding items

    public void addPizza(Pizza p){
        pizzas.add(p);
    }

}
