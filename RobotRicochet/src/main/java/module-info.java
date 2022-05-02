module com.example.robotricochet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.robotricochet to javafx.fxml;
    exports com.example.robotricochet;
}