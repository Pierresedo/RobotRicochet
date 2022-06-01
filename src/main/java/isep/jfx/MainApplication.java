package isep.jfx;

import isep.ricrob.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        Game.start();
        FXMLLoader fxmlLoader = new FXMLLoader
                (MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        final URL musicURL = getClass().getResource("music.mp3");
       // final Media media = new Media(musicURL.toExternalForm());
        stage.setTitle("Ricochet Robots");
        stage.setScene(scene);
        stage.show();

    }



}