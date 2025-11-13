package com.pluralsight.shop.toppings.regularTopping;

import com.pluralsight.shop.toppings.Topping;

public class Sauce extends Topping {

    public Sauce(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }
}



