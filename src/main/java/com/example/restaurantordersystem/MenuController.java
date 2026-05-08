package com.example.restaurantordersystem;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MenuController {

    @FXML
    private Label statusLabel;

    @FXML
    private ListView<String>
            menuListView;

    @FXML
    private ListView<String>
            orderHistoryListView;

    private NetworkClient client =
            NetworkClient.getInstance();

    private int selectedTableId = 1;

    // Update selected table number.
    public void setSelectedTableId(
            int selectedTableId) {

        this.selectedTableId =
                selectedTableId;
    }

    // Request menu items from the server.
    @FXML
    public void requestMenu() {

        if (!client.isConnected()) {

            statusLabel.setText(
                    "Not connected to server."
            );

            return;
        }

        menuListView
                .getItems()
                .clear();

        statusLabel.setText(
                "Loading menu..."
        );

        // Run networking tasks in separate threads
        // to prevent freezing the JavaFX GUI.
        new Thread(() -> {

            client.sendMessage(
                    Protocol.GET_MENU
            );

            String response;

            while ((response =
                    client.receiveMessage()) != null) {

                String finalResponse =
                        response;

                if (finalResponse.equals(
                        "MENU_END")) {

                    break;
                }

                javafx.application.Platform
                        .runLater(() -> {

                            if (!finalResponse.equals(
                                    "MENU_START")) {

                                menuListView
                                        .getItems()
                                        .add(finalResponse);
                            }
                        });
            }

            javafx.application.Platform
                    .runLater(() -> {

                        menuListView
                                .getSelectionModel()
                                .setSelectionMode(
                                        javafx.scene.control
                                                .SelectionMode.MULTIPLE
                                );

                        statusLabel.setText(
                                "Menu loaded successfully."
                        );
                    });

        }).start();
    }

    // Send selected order items to the server.
    @FXML
    public void placeOrder() {

        if (!client.isConnected()) {

            statusLabel.setText(
                    "Not connected to server."
            );

            return;
        }

        ObservableList<String>
                selectedItems =

                menuListView
                        .getSelectionModel()
                        .getSelectedItems();

        if (selectedItems.isEmpty()) {

            statusLabel.setText(
                    "Please select an item."
            );

            return;
        }

        Order order =
                new Order(
                        selectedTableId
                );

        for (String item :
                selectedItems) {

            order.addItem(item);
        }

        statusLabel.setText(
                "Sending order..."
        );

        new Thread(() -> {

            String orderData =
                    String.join(
                            ",",
                            selectedItems
                    );

            client.sendMessage(
                    Protocol.PLACE_ORDER
                            + ":"
                            + selectedTableId
                            + ":"
                            + orderData
            );

            String response =
                    client.receiveMessage();

            javafx.application.Platform
                    .runLater(() -> {

                        orderHistoryListView
                                .getItems()
                                .add(
                                        order.toString()
                                );

                        statusLabel.setText(
                                response
                        );
                    });

        }).start();
    }
}