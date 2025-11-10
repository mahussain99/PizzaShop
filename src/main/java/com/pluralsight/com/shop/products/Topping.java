package com.pluralsight.com.shop.products;

public abstract class Topping {
    private String name;

    public Topping(String name, String s) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addExtra(Topping Tp) {

    }

    public double getCost() {


        return 0;
    }
}
