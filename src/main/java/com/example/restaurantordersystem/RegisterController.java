package com.example.restaurantordersystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    // Save newly registered users to file.
    @FXML
    public void handleRegister() {

        String username =
                usernameField.getText();

        String password =
                passwordField.getText();

        if (username.isEmpty() ||
                password.isEmpty()) {

            statusLabel.setText(
                    "Please fill all fields."
            );

            return;
        }

        try {

            FileWriter writer =
                    new FileWriter(
                            System.getProperty("user.home")
                                    + "/users.txt",
                            true
                    );

            writer.write(
                    username
                            + ","
                            + password
                            + "\n"
            );

            writer.close();

            statusLabel.setText(
                    "Registration successful."
            );

        } catch (IOException e) {

            statusLabel.setText(
                    "Error saving user."
            );
        }
    }

    @FXML
    public void backToLogin() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass()
                                    .getResource(
                                            "/com/example/restaurantordersystem/login.fxml"
                                    )
                    );

            Parent root =
                    loader.load();

            Stage stage =
                    (Stage) usernameField
                            .getScene()
                            .getWindow();

            Scene scene =
                    new Scene(
                            root,
                            500,
                            400
                    );

            var cssResource =
                    getClass()
                            .getResource(
                                    "/com/example/restaurantordersystem/style.css"
                            );

            if (cssResource != null) {

                scene.getStylesheets().add(
                        cssResource.toExternalForm()
                );
            }

            stage.setScene(scene);

        } catch (Exception e) {

            statusLabel.setText(
                    "Failed to return to login."
            );
        }
    }
}