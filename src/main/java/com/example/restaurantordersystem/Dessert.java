package com.example.restaurantordersystem;

public class Dessert extends MenuItem {

    private boolean coldServed;

    public Dessert(int id, String name, double price,
                   String description, String category,
                   boolean coldServed) {

        super(id, name, price, description, category);

        this.coldServed = coldServed;
    }

    public boolean isColdServed() {
        return coldServed;
    }

    @Override
    public String getDetails() {

        return "Dessert: " + getName() +
                " | Price: $" + getPrice() +
                " | Cold Served: " + coldServed;
    }
}