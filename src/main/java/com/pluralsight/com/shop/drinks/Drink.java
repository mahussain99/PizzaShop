package com.pluralsight.com.shop.drinks;

public class Drink {
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {


        return 0;
    }

    }



