package com.pluralsight.shop.mainMune;

import com.pluralsight.shop.order.Order;
import com.pluralsight.shop.products.Drink;
import com.pluralsight.shop.products.GarlicKnots;
import com.pluralsight.shop.products.Pizza;
import com.pluralsight.shop.receipt.ReceiptFileManager;
import com.pluralsight.shop.toppings.Topping;
import com.pluralsight.shop.toppings.premiumTopping.Cheese;
import com.pluralsight.shop.toppings.premiumTopping.Meat;
import com.pluralsight.shop.toppings.regularTopping.RegularTopping;
import com.pluralsight.shop.toppings.regularTopping.Sauce;
import com.pluralsight.shop.toppings.regularTopping.Side;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private Order currentOrder;

    public void pizzaShop() {
        boolean running = false;
        while (!running) {

            System.out.println(     "\n==== Welcome to Pizza Shop ====");
            System.out.println("--------------------------------------------");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    takeOrder();
                    break;
                case "0":
                    running = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    public void takeOrder() {
        currentOrder = new Order(LocalDateTime.now());
        boolean order = true;
        while (order) {
            System.out.println("\n===== Order Screen =====");
            System.out.println("---------------------------");
            System.out.println(" ");
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    createPizza();
                    break;
                case "2":
                    createDrink();
                    break;
                case "3":
                    addGarlicKnots();
                    break;
                case "4":
                    checkout();
                    order = false;
                    break;
                case "0":
                    cancelOrder();
                    order = false;
                    break;
                default:
                    System.out.println("Invalid input!");


            }
        }
    }

    public void createPizza() {
        System.out.println("\n=======Order Your Pizza=========");
        System.out.println(" ");
        System.out.print("Choose pizza size (Personal, Medium, Large): ");

        String pizzaSize = scanner.nextLine().trim();
        if (pizzaSize.equalsIgnoreCase("personal") || pizzaSize.equalsIgnoreCase("Medium") || pizzaSize.equalsIgnoreCase("Large")) {
            System.out.println("You chose pizza is: " + pizzaSize);
        } else {
            System.out.println("Invalid choose option. Default Pizza small");
            pizzaSize = "small";
        }
        System.out.print("Enter crust type: (Thin, Regular, Thick, or Cauliflower): ");
        String crustType = scanner.nextLine();
        if (crustType.equalsIgnoreCase("Thin") || crustType.equalsIgnoreCase("Regular") || crustType.equalsIgnoreCase("Thick") || crustType.equalsIgnoreCase("Cauliflower")) {

            System.out.println("Crust type chose: " + crustType);

        } else {
            System.out.println("Invalid crust. Defaulting to Regular.");
            crustType = "Regular";
        }
        System.out.print("Stuffed crust? (yes/no): ");
        boolean stuffed = scanner.nextLine().equalsIgnoreCase("yes");
        if (stuffed) {
            System.out.println("Yes, Pizza stuffed cruse");
        } else {
            System.out.println("No, Pizza not Stuffed crust");
        }
        Pizza pizza = new Pizza(pizzaSize, crustType, true);

        System.out.println(" ");
        System.out.println("A Regular toppings on the Pizza");
        System.out.println("------------------------------------ ");
        List<String> toppings = Arrays.asList("Available Toppings: ", "onion", "bell peppers", "mushrooms", "olives", "tomatoes", "spinach", "basil", "pineapple", "anchovies");
        boolean run = true;
        while (run) {
            toppings.forEach(System.out::println);
            System.out.print("Enter toppings name: ");
            String regularToppingName = scanner.nextLine().trim();
            if (!toppings.stream().anyMatch(c -> c.equalsIgnoreCase(regularToppingName))) {
                System.out.println("Sorry topping not in the list");
                continue;
            } else {
                RegularTopping topping = new RegularTopping(regularToppingName);
                pizza.addTopping(topping);
                System.out.println("Toppings added successfully ");
            }

            System.out.print("Would you like to add another topping? (yes/no): ");
            String answer = scanner.nextLine().trim();
            if (!answer.equalsIgnoreCase("yes")) {
                run = false;
            }
        }
        System.out.println("--------------------------------------------------------");
        // Asked for sauce
        System.out.print("Adding sauce on the Pizza");
        System.out.println("\n------------------------- ");
        // System.out.println("Available Sauces: marinara, alfredo, pesto, bbq, buffalo and olive oil");
        List<String> sauces = Arrays.asList("Available Sauces below list: ", "Marinara", "Alfredo", "Pesto", "BBQ", "Buffalo", "Olive oil");
        boolean running = true;
        while (running) {
            sauces.forEach(System.out::println);
            System.out.print("Enter sauce name: ");
            String sauceName = scanner.nextLine().trim();
            if (!sauces.stream().anyMatch(c -> c.equalsIgnoreCase(sauceName))) {
                System.out.println("Sorry, Sauce not in the list ");
                continue;
            } else {
                Sauce regularSauces = new Sauce(sauceName);
                pizza.addTopping(regularSauces);
                System.out.println("All Sauces added successfully");
            }

            System.out.print("Would you like to add more sauces? (yes/no): ");
            String answer = scanner.nextLine().trim();
            if (!answer.equalsIgnoreCase("yes")) {
                running = false;
            }
        }
        System.out.println("----------------------------------------------- ");
        System.out.print("Adding Side option--> ");
        List<String> side = Arrays.asList("Side available: ", "Red pepper", "Parmesan");
        boolean sided = true;
        while (sided) {
            side.forEach(System.out::println);
            System.out.print("Enter Side option: ");
            String sideName = scanner.nextLine().trim();
            if (!side.stream().anyMatch(c -> c.equalsIgnoreCase(sideName))) {
                System.out.println("Sorry, not in the list");
                continue;

            } else {

                Side sideOptions = new Side(sideName);
                pizza.addTopping(sideOptions);
                System.out.println("Side added successfully ");
            }
            System.out.print("Would you like more (yes/no) ");
            String yesOrNo = scanner.nextLine().trim();
            if (!yesOrNo.equalsIgnoreCase("yes")) sided = false;
        }

        boolean premiumToppings = true;
        while (premiumToppings) {
            System.out.println("----------------------------------------------------------");
            System.out.println("What kind premium topping do you like (meats/cheese)");
            System.out.println(" ");
            System.out.println("1) Meats");
            System.out.println("2) Cheese");
            System.out.println("0) Exit");
            System.out.print("Enter chose: ");
            String chose = scanner.nextLine();

            switch (chose) {
                case "1":
                    List<String> meats = Arrays.asList("pepperoni", "sausage", "ham", "bacon", "chicken", "meatball");
                    boolean meatsOption = true;
                    while (meatsOption) {
                        meats.forEach(System.out::println);
                        System.out.println("----------------------");
                        System.out.print("Enter Meats name: ");
                        String meatsName = scanner.nextLine().trim();
                        if (!meats.stream().anyMatch(c -> c.equalsIgnoreCase(meatsName))) {
                            System.out.println("This meats not in the list");
                            continue;
                        } else {
                            System.out.print("Do you want to extra meats ? (yes/no): ");
                            boolean hasExtra = scanner.nextLine().trim().equalsIgnoreCase("yes");
                            Topping meatsTopping = new Meat(meatsName, hasExtra);
                            pizza.addTopping(meatsTopping);

                            System.out.println("Meats added successfully");
                            meatsOption = false;

                        }
                    }
                    break;
                case "2":
                    List<String> cheese = Arrays.asList("Mozzarella", "Parmesan", "Ricotta", "Goat Cheese", "Buffalo");
                    boolean cheeseOption = true;
                    while (cheeseOption) {
                        cheese.forEach(System.out::println);
                        System.out.println("-------------------------");
                        System.out.print("Enter cheese name: ");
                        String cheeseName = scanner.nextLine().trim();

                        if (!cheese.stream().anyMatch(c -> c.equalsIgnoreCase(cheeseName))) {
                            System.out.println("This cheese not in the list");
                            continue;
                        } else {
                            System.out.print("Do you want to extra cheese " + cheeseName + " ? (yes/no): ");
                            boolean hasExtra = scanner.nextLine().trim().equalsIgnoreCase("yes");
                            Topping cheeseTopping = new Cheese(cheeseName, hasExtra);
                            pizza.addTopping(cheeseTopping);
                            System.out.println("Cheese added successfully");
                            cheeseOption = false;

                        }
                    }
                    break;
                case "0":
                    premiumToppings = false;
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
                    break;
            }

        }

        currentOrder.addPizza(pizza);
        System.out.println("Successfully adding Pizza to your order!");
    }

    public void createDrink() {
        System.out.println("\n---------- Adding drink to Order -----------");
        System.out.print("Choose drink size: (SMALL, MEDIUM, LARGE): ");
        System.out.println("\n-------------------------------------------");
        String drinkSize = scanner.nextLine().trim();
        if (drinkSize.equalsIgnoreCase("small") || drinkSize.equalsIgnoreCase("medium") || drinkSize.equalsIgnoreCase("large")) {
            System.out.println("Drink size is: " + drinkSize);
        } else {
            System.out.println("Invalid option default to SMALL");
            drinkSize = "SMALL";
        }

        System.out.print("What kind of flavor do you like? (Sprite, Coke, Water, Brisk, Orange): ");
        System.out.println("\n------------------------------------------------------------------------");
        String flavor = scanner.nextLine().trim();
        if (flavor.equalsIgnoreCase("(Sprite, Coke, Water, Brisk, Orange): "))
            System.out.println("Flavor chose " + flavor);

        Drink drink = new Drink(drinkSize, flavor);

        currentOrder.addDrinks(drink);
        System.out.println("Successfully adding drink to your order");
    }

    public void addGarlicKnots() {
        System.out.print("\nWould you like to add garlic knots? (yes/no): ");
        String answer = scanner.nextLine().trim();

        if (answer.equalsIgnoreCase("yes")) {
            System.out.print("Enter seasoning for the garlic knots: (parsley, garlic butter, parmesan): ");
            String seasoning = scanner.nextLine().trim();

            GarlicKnots garlicKnots = new GarlicKnots((seasoning));
            currentOrder.addGarlicKnots(garlicKnots);
            System.out.println("Garlic knots with " + seasoning + " added to your order!");

        } else {
            System.out.println("No garlic knots added.");

        }
    }

    public void checkout() {
        System.out.println("\n--- Checkout Summary ---");
        System.out.println("\n-----------------------------------");
        System.out.println("Order ID: " + currentOrder.getOrderID());
        System.out.println("Date: " + currentOrder.getDateTime());

        System.out.println("\nPizzas:");
        for (Pizza pizza : currentOrder.getPizzas()) {
            System.out.println("- " + pizza.getPizzaSize() + " pizza with " + pizza.getCrustType()
                    + " crust" + (pizza.isStuffedCrust() ? " (stuffed)" : ""));

            for (Topping topping : pizza.getToppings()) {
                System.out.println("   • " + topping.getName());
            }
            System.out.printf("  Price: $%.2f\n", pizza.getPrice());
        }

        System.out.println("\nDrinks:");
        for (Drink drink : currentOrder.getDrinks()) {
            System.out.println("- " + drink.getDrinkSize() + " " + drink.getFlavor()
                    + " ($" + drink.getPrice() + ")");
        }

        System.out.println("\nGarlic Knots:");
        for (GarlicKnots gk : currentOrder.getGarlicKnots()) {
            System.out.println("- " + gk.getSeasoning() + " ($" + gk.getPrice() + ")");
        }

        System.out.print("\nWould you like to confirm your order? (yes/no): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("yes")) {
            System.out.println("Order confirmed.");

            ReceiptFileManager fileManager = new ReceiptFileManager();
            fileManager.saveReceipt(currentOrder);

            System.out.printf("\nTotal: $%.2f\n", currentOrder.getTotal());
            System.out.println("Thank you for your order!");

        } else {
            System.out.println("Order cancelled.");
        }
    }

    public void cancelOrder() {
        System.out.println("\nDo you want to cancel the order? (yes/no): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("yes")) {
            currentOrder = null;
            System.out.println("Your order has been cancelled.");
        } else {
            System.out.println("Cancellation aborted. Returning to order menu...");
        }
    }

}
