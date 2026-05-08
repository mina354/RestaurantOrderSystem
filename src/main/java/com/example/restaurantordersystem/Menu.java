package com.example.restaurantordersystem;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuItem> menuItems;

    public Menu() {

        menuItems = new ArrayList<>();

        loadMenuItems();
    }

    private void loadMenuItems() {

        menuItems.add(
                new Appetizer(
                        1,
                        "French Fries",
                        50,
                        "Crispy fries",
                        "Appetizer",
                        false
                )
        );

        menuItems.add(
                new MainCourse(
                        2,
                        "Burger",
                        120,
                        "Beef burger",
                        "Main Course",
                        850
                )
        );

        menuItems.add(
                new Dessert(
                        3,
                        "Ice Cream",
                        60,
                        "Vanilla ice cream",
                        "Dessert",
                        true
                )
        );

        menuItems.add(
                new Beverage(
                        4,
                        "Cola",
                        30,
                        "Cold drink",
                        "Beverage",
                        false
                )
        );
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}