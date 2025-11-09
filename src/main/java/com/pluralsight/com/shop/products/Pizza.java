package com.pluralsight.com.shop.products;

import java.util.ArrayList;

public class Pizza {
    private pizzaSize size;
    private String crustType;
    private boolean stuffedCrust;
    private ArrayList<Topping> toppings;

    public Pizza(pizzaSize size, String crustType, boolean stuffedCrust) {
        this.size = size;
        this.crustType = crustType;
        this.stuffedCrust = stuffedCrust;
        this.toppings = new ArrayList<>();
    }

    public pizzaSize getSize() {
        return size;
    }

    public String getCrustType() {
        return crustType;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    public void addTopping(Topping tp) {
        toppings.add(tp);
    }
    public double getPrice() {
        double price = 0;

// looking for price base on the pizza size

        // I want to use switch case here for looking for each pizza size
        /*switch (size){
            case PERSONA:
                price += 8.50;
                break;

                case MEDIUM:
                price += 12.00;
                break;

              Case LARGE:
               price += 16.50;
                break;

                */

        if (stuffedCrust) {
            price += 3.00;

            for (Topping tp : toppings) {
                price += getCost();

            }
            return price; // just for understanding
        }
    }


    public enum PizzaSize {
        PERSONAL, MEDIUM, LARGE
    }
}


