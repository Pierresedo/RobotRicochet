module isep.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens isep.jfx to javafx.fxml;
    exports isep.jfx;
}