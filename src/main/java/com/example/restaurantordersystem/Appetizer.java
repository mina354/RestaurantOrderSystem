package com.example.restaurantordersystem;

public class Appetizer extends MenuItem {

    private boolean spicy;

    public Appetizer(int id, String name, double price,
                     String description, String category,
                     boolean spicy) {

        super(id, name, price, description, category);

        this.spicy = spicy;
    }

    public boolean isSpicy() {
        return spicy;
    }

    @Override
    public String getDetails() {

        return "Appetizer: " + getName() +
                " | Price: $" + getPrice() +
                " | Spicy: " + spicy;
    }
}