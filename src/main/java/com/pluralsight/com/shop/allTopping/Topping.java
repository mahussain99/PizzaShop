package com.pluralsight.com.shop.allTopping;

import com.pluralsight.com.shop.products.Pizza;

public abstract class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addExtra(Topping topping) {

    }

    public abstract double getPrice(Pizza.PizzaSize size);
}
