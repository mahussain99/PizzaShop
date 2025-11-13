package com.pluralsight.shop.products;

public class Drink {
    private String drinkSize;
    private String flavor;

    public Drink(String drinkSize, String flavor) {
        this.drinkSize = drinkSize;
        this.flavor = flavor;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        double basePrice = 0;
        if (drinkSize.equalsIgnoreCase("SMALL")) {
            basePrice = 2.00;

        } else if (drinkSize.equalsIgnoreCase("MEDIUM")) {
            basePrice = 2.50;

        } else if (drinkSize.equalsIgnoreCase("LARGE")) {
            basePrice = 3.00;
        } else basePrice = 0;

        return basePrice;
    }
}



