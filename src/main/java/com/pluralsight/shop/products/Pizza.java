package com.pluralsight.shop.products;

import com.pluralsight.shop.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String pizzaSize;
    private String crustType;
    private boolean stuffedCrust;
    private List<Topping> toppings;

    public Pizza(String pizzaSize, String crustType, boolean stuffedCrust) {
        this.pizzaSize = pizzaSize;
        this.crustType = crustType;
        this.stuffedCrust = stuffedCrust;
        this.toppings = new ArrayList<>();
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getCrustType() {
        return crustType;
    }

    public void setCrustType(String crustType) {
        this.crustType = crustType;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getPrice() {

        double basePrice;
        if (pizzaSize.equalsIgnoreCase("PERSONAL")) {
            basePrice = 8.50;
        } else if (pizzaSize.equalsIgnoreCase("MEDIUM")) {
            basePrice = 12.00;

        } else if (pizzaSize.equalsIgnoreCase("LARGE")) {
            basePrice = 16.50;

        } else {
            return 0;
        }
            for (Topping tp : toppings) {
                basePrice += tp.getPrice(pizzaSize);

            }
            return basePrice;
        }

        // display ===
    // toString
}



