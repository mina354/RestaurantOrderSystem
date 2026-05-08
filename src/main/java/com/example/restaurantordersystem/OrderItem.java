package com.example.restaurantordersystem;

public class OrderItem {

    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem,
                     int quantity) {

        if (menuItem == null) {

            throw new IllegalArgumentException(
                    "Menu item cannot be null."
            );
        }

        if (quantity <= 0) {

            throw new IllegalArgumentException(
                    "Quantity must be greater than 0."
            );
        }

        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {

        return menuItem.getPrice()
                * quantity;
    }
}