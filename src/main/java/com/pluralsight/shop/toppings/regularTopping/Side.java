package com.pluralsight.shop.toppings.regularTopping;

import com.pluralsight.shop.toppings.Topping;

public class Side extends Topping {
    public Side(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }


}
