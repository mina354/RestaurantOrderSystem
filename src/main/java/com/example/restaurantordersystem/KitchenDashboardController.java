package com.example.restaurantordersystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class KitchenDashboardController {

    @FXML
    private Label kitchenLabel;

    @FXML
    public void refreshOrders() {

        kitchenLabel.setText(
                "Kitchen orders refreshed."
        );
    }
}