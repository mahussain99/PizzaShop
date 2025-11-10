package com.pluralsight.com.shop.allTopping;

import com.pluralsight.com.shop.products.Pizza;

public class Meats extends PremiumTopping {
    private String name;

    public Meats(String name, boolean hasExtra) {
        super(name, hasExtra);

    }

    // Setting regular price base on needed
    @Override
    public double getPrice(Pizza.PizzaSize size) {
        double basePrice = 0;

        if (size == Pizza.PizzaSize.PERSONAL) {
            basePrice = 1.00;
        } else if (size == Pizza.PizzaSize.MEDIUM) {
            basePrice = 2.00;

        } else if (size == Pizza.PizzaSize.LARGE) {
            basePrice = 3.00;

        }
        // set a extra meat price
        if (hasExtra()) {
            if (size == Pizza.PizzaSize.PERSONAL) {
                basePrice += 0.50;
            } else if (size == Pizza.PizzaSize.MEDIUM) {
                basePrice += 1.00;
            } else if (size == Pizza.PizzaSize.LARGE) {
                basePrice += 1.50;
            }

        }
        return basePrice;
    }
}








