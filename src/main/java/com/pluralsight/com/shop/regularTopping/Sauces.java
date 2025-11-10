package com.pluralsight.com.shop.regularTopping;

import com.pluralsight.com.shop.allTopping.Topping;
import com.pluralsight.com.shop.products.Pizza;

public class Sauces extends Topping {
    private String name;

    public Sauces(String name) {
        super(name);
    }

    @Override
    public double getPrice(Pizza.PizzaSize size) {
        return 0;
    }
}



