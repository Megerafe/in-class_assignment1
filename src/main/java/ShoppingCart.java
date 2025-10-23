package com.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {
    private List<Item> items;
    private ResourceBundle messages;

    public ShoppingCart(Locale locale) {
        this.items = new ArrayList<>();
        this.messages = ResourceBundle.getBundle("MessagesBundle", locale);
    }


    public double calculateItemCost(double price, int quantity) {
        return price * quantity;
    }


    public double calculateTotalCost() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getTotalCost();
        }
        return total;
    }


    public void addItem(double price, int quantity) {
        double totalCost = calculateItemCost(price, quantity);
        items.add(new Item(price, quantity, totalCost));
    }


    public String getMessage(String key) {
        return messages.getString(key);
    }

    // Main method to run the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simple language selection
        System.out.println("Enter the language initials (en/fi/sv/ja):");
        String language = scanner.nextLine();

        System.out.println("Enter the country initials (US/FI/SE/JP):");
        String country = scanner.nextLine();

        Locale locale = new Locale(language, country);
        ShoppingCart cart = new ShoppingCart(locale);

        // Get number of items
        System.out.print(cart.getMessage("prompt.items") + " ");
        int numItems = scanner.nextInt();

        // Get price and quantity for each item
        for (int i = 1; i <= numItems; i++) {
            System.out.print(cart.getMessage("prompt.price") + " " + i + ": ");
            double price = scanner.nextDouble();

            System.out.print(cart.getMessage("prompt.quantity") + " " + i + ": ");
            int quantity = scanner.nextInt();

            cart.addItem(price, quantity);
        }

        // Display total cost
        double total = cart.calculateTotalCost();
        System.out.printf("%s %.2f\n", cart.getMessage("label.total"), total);

        scanner.close();
    }
}

// Inner class to represent an item
class Item {
    private double price;
    private int quantity;
    private double totalCost;

    public Item(double price, int quantity, double totalCost) {
        this.price = price;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }
}