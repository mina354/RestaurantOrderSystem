package com.example.restaurantordersystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OrderStatusController {

    @FXML
    private Label statusLabel;

    public void updateStatus(
            String status) {

        statusLabel.setText(status);
    }
}