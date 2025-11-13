package com.pluralsight.shop.order;
import com.pluralsight.shop.products.Drink;
import com.pluralsight.shop.products.GarlicKnots;
import com.pluralsight.shop.products.Pizza;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderID;
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private List<GarlicKnots> garlicKnots;
    private LocalDateTime dateTime;

    public Order(LocalDateTime dateTime) {

        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = new ArrayList<>();
        this.dateTime = LocalDateTime.now();
        this.orderID = dateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
    }


    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<GarlicKnots> getGarlicKnots() {
        return garlicKnots;
    }

    public void setGarlicKnots(List<GarlicKnots> garlicKnots) {
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

    public void addGarlicKnots(GarlicKnots gK) {
        garlicKnots.add(gK);
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

        for (GarlicKnots gk: garlicKnots) {
            total += gk.getPrice();
        }
        return total; // just for understanding
    }

    @Override
    public String toString() {
        return "Order #" + orderID + " with" + pizzas.size() +
                "pizzas" + drinks.size() + "drinks.";

    }
}



