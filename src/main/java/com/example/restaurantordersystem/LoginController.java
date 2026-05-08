package com.example.restaurantordersystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    private NetworkClient client =
            NetworkClient.getInstance();

    // Validate login fields before connecting.
    @FXML
    public void handleLogin() {

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

        statusLabel.setText(
                "Connecting to server..."
        );

        client.connect();

        if (!client.isConnected()) {

            statusLabel.setText(
                    "Server is unavailable."
            );

            return;
        }

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass()
                                    .getResource(
                                            "/com/example/restaurantordersystem/table-selection.fxml"
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
                            700,
                            500
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
                    "Failed to load main screen."
            );
        }
    }

    @FXML
    public void openRegisterScreen() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass()
                                    .getResource(
                                            "/com/example/restaurantordersystem/register.fxml"
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
                    "Failed to open register screen."
            );
        }
    }
}