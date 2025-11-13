package com.pluralsight.shop.toppings.premiumTopping;

public class Meat extends PremiumTopping {
    public Meat(String name, boolean hasExtra) {
        super(name, hasExtra);

    }

    // Setting regular price base on needed
    @Override
    public double getPrice(String pizzaSize ) {
        double basePrice = 0;

        if (pizzaSize.equalsIgnoreCase("PERSONAL")) {
            basePrice = 1.00;
        } else if (pizzaSize.equalsIgnoreCase("MEDIUM")) {
            basePrice = 2.00;

        } else if (pizzaSize.equalsIgnoreCase("LARGE")) {
            basePrice = 3.00;

        }
        // set a extra meat price
        if (hasExtra()) {
            if (pizzaSize.equalsIgnoreCase("PERSONAL")) {
                basePrice += 0.50;
            } else if (pizzaSize.equalsIgnoreCase("MEDIUM")) {
                basePrice += 1.00;
            } else if (pizzaSize.equalsIgnoreCase("LARGE")) {
                basePrice += 1.50;
            } else {
                basePrice = 0;
            }

        }
        return basePrice;
    }
}








