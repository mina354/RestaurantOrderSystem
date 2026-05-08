package com.example.restaurantordersystem;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int tableId;

    private List<String> items;

    private String status;

    public Order(int tableId) {

        this.tableId = tableId;

        this.items =
                new ArrayList<>();

        this.status =
                "Preparing";
    }

    public void addItem(
            String item) {

        items.add(item);
    }

    public int getTableId() {

        return tableId;
    }

    public List<String> getItems() {

        return items;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(
            String status) {

        this.status = status;
    }

    @Override
    public String toString() {

        return "Table "
                + tableId
                + " | "
                + items
                + " | "
                + status;
    }
}