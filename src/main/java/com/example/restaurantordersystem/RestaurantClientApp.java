package com.example.restaurantordersystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RestaurantClientApp
        extends Application {

    @Override
    public void start(Stage stage)
            throws Exception {

        FXMLLoader loader =
                new FXMLLoader(
                        getClass()
                                .getResource(
                                        "/com/example/restaurantordersystem/login.fxml"
                                )
                );

        Scene scene =
                new Scene(
                        loader.load(),
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

        stage.setTitle(
                "Restaurant System"
        );

        stage.setMinWidth(400);

        stage.setMinHeight(300);

        stage.setScene(scene);

        stage.show();
    }

    @SuppressWarnings("unused")
    public static void main(
            String[] args) {

        launch(args);
    }
}