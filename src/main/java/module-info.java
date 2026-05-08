module com.example.restaurantordersystem {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.restaurantordersystem
            to javafx.fxml;

    exports com.example.restaurantordersystem;
}