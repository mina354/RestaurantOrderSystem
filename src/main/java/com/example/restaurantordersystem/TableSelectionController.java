package com.example.restaurantordersystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TableSelectionController {

    @FXML
    private Label infoLabel;

    @FXML
    public void selectTable1() {

        openMainScreen(1);
    }

    @FXML
    public void selectTable2() {

        openMainScreen(2);
    }

    // Open dashboard screen for selected table.
    private void openMainScreen(
            int tableId) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass()
                                    .getResource(
                                            "/com/example/restaurantordersystem/main.fxml"
                                    )
                    );

            Parent root =
                    loader.load();

            MenuController controller =
                    loader.getController();

            controller.setSelectedTableId(
                    tableId
            );

            Stage stage =
                    (Stage) infoLabel
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

            infoLabel.setText(
                    "Failed to load screen."
            );
        }
    }
}