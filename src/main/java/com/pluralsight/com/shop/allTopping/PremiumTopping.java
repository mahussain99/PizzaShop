package com.pluralsight.com.shop.allTopping;

import com.pluralsight.com.shop.products.Pizza;

public class PremiumTopping extends Topping {
    private  boolean hasExtra;
    private String name;

    public PremiumTopping(String name, boolean hasExtra) {
        super(name);
        this.hasExtra = hasExtra;
    }

    public boolean hasExtra() {
        return hasExtra;

    }

    @Override
    public double getPrice(Pizza.PizzaSize size) {
        double basePrice = 0;
        if (size == Pizza.PizzaSize.PERSONAL) {
            basePrice = 1.00;
        } else if (size == Pizza.PizzaSize.MEDIUM) {
            basePrice = 2.00;
        } else if (size == Pizza.PizzaSize.LARGE) {
            basePrice = 3.00;
        }else {
            basePrice = 0.00;
        }
        if (hasExtra) {
            basePrice = basePrice * 2;

        }
        return basePrice;
    }
    public void addExtra() {
            this.hasExtra = true;


    }
}






