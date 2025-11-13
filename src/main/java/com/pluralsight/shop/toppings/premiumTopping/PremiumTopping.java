package com.pluralsight.shop.toppings.premiumTopping;

import com.pluralsight.shop.toppings.Topping;

public abstract class PremiumTopping extends Topping {
    private boolean hasExtra;

    public PremiumTopping(String name, boolean hasExtra) {
        super(name);
        this.hasExtra = hasExtra;
    }

    public boolean hasExtra() {
        return hasExtra;

    }


    public abstract double getPrice(String pizzaSize);

}






