package com.pluralsight.shop.toppings.regularTopping;

import com.pluralsight.shop.toppings.Topping;
import com.pluralsight.shop.products.Pizza;

public class RegularTopping extends Topping {
    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }

}


