package com.pluralsight.shop.receipt;

import com.pluralsight.shop.order.Order;

import com.pluralsight.shop.products.Pizza;
import com.pluralsight.shop.products.Drink;
import com.pluralsight.shop.products.GarlicKnots;
import com.pluralsight.shop.toppings.Topping;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

        public void saveReceipt(Order order) {
            String fileName = "receipt-" + order.getOrderID() + ".txt";

            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write("--- Receipt ---\n");
                writer.write("Order ID: " + order.getOrderID() + "\n");
                writer.write("Date: " + order.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n\n");

                writer.write("Pizzas:\n");
                for (Pizza pizza : order.getPizzas()) {
                    writer.write("- " + pizza.getPizzaSize() + " pizza with " + pizza.getCrustType());
                    if (pizza.isStuffedCrust()) writer.write(" (stuffed)");
                    writer.write("\n");

                    for (Topping topping : pizza.getToppings()) {
                        writer.write("   • " + topping.getName() + "\n");
                    }

                    writer.write(String.format("  Price: $%.2f\n", pizza.getPrice()));
                }

                writer.write("\nDrinks:\n");
                for (Drink drink : order.getDrinks()) {
                    writer.write("- " + drink.getDrinkSize() + " " + drink.getFlavor() +
                            String.format(" ($%.2f)\n", drink.getPrice()));
                }

                writer.write("\nGarlic Knots:\n");
                for (GarlicKnots knots : order.getGarlicKnots()) {
                    writer.write("- " + knots.getSeasoning() +
                            String.format(" ($%.2f)\n", knots.getPrice()));
                }

                writer.write(String.format("\nTotal: $%.2f\n", order.getTotal()));
                writer.write("Thank you for your order!\n");

                System.out.println("Receipt saved to " + fileName);
            } catch (IOException e) {
                System.out.println("Failed to save receipt: " + e.getMessage());
            }
        }
    }



