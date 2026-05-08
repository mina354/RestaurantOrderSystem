package com.example.restaurantordersystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RestaurantService {

    private ConcurrentHashMap<Integer, Order>
            activeOrders;

    private ConcurrentHashMap<Integer, Table>
            tables;

    private Menu menu;

    public RestaurantService() {

        activeOrders =
                new ConcurrentHashMap<>();

        tables =
                new ConcurrentHashMap<>();

        menu = new Menu();
    }

    public void addOrder(Order order) {

        if (order == null) {

            throw new IllegalArgumentException(
                    "Order cannot be null."
            );
        }

        activeOrders.put(
                order.getTableId(),
                order
        );
    }

    public Order getOrder(int tableId) {

        return activeOrders.get(tableId);
    }

    public void updateOrderStatus(
            int tableId,
            String status) {

        Order order =
                activeOrders.get(tableId);

        if (order != null) {

            order.setStatus(status);
        }
        else {

            System.out.println(
                    "Order not found."
            );
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public Map<Integer, Order>
    getActiveOrders() {

        return activeOrders;
    }

    public Map<Integer, Table>
    getTables() {

        return tables;
    }
}