package com.example.restaurantordersystem;

public class Table {

    private int tableNumber;
    private String status;
    private Order currentOrder;

    public Table(int tableNumber) {

        this.tableNumber = tableNumber;

        this.status = "FREE";
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}