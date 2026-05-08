package com.example.restaurantordersystem;

public class MainCourse extends MenuItem {

    private int calories;

    public MainCourse(int id, String name, double price,
                      String description, String category,
                      int calories) {

        super(id, name, price, description, category);

        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String getDetails() {

        return "Main Course: " + getName() +
                " | Price: $" + getPrice() +
                " | Calories: " + calories;
    }
}