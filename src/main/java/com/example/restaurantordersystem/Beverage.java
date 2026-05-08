package com.example.restaurantordersystem;

public class Beverage extends MenuItem {

    private boolean hasAlcohol;

    public Beverage(int id, String name, double price,
                    String description, String category,
                    boolean hasAlcohol) {

        super(id, name, price, description, category);

        this.hasAlcohol = hasAlcohol;
    }

    public boolean hasAlcohol() {
        return hasAlcohol;
    }

    @Override
    public String getDetails() {

        return "Beverage: " + getName() +
                " | Price: $" + getPrice() +
                " | Alcohol: " + hasAlcohol;
    }
}