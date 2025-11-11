package com.pluralsight.shop.toppings.premiumTopping;

public class Cheese extends PremiumTopping {

    public Cheese(String name, boolean hasExtra) {
        super(name, hasExtra);

    }

    @Override
    public double getPrice(String pizzaSize) {
        double basePrice = 0;

        if (pizzaSize.equalsIgnoreCase("PERSONAL")) {
            basePrice = 0.75;
        } else if (pizzaSize.equalsIgnoreCase("MEDIUM")) {
            basePrice = 1.50;

        } else if (pizzaSize.equalsIgnoreCase("LARGE")) {
            basePrice = 2.25;

        }
        // set a extra meat price
        if (hasExtra()) {
            if (pizzaSize.equalsIgnoreCase("PERSONAL")) {
                basePrice += 0.30;
            } else if (pizzaSize.equalsIgnoreCase("MEDIUM")) {
                basePrice += 0.60;

            } else if (pizzaSize.equalsIgnoreCase("LARGE")) {
                basePrice += 0.90;
            } else {
                basePrice = 0;

            }

        }
        return basePrice;
    }
}


// I am not finished

