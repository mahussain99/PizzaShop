package com.pluralsight.com.shop.products;

public class GarlicKnots {
    private double amount ;

    public GarlicKnots(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    // GarlicNots price $1.50
     public double getPrice(){
        return  amount * 1.50;

     }


}
