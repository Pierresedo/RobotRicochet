package isep.jfx;

import isep.ricrob.Game;
import isep.ricrob.Token;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static isep.ricrob.Token.Color.*;

public class MainController {

    public final int TILE_SIZE = 40;

    @FXML
    public GridPane boardPane;



    @FXML
    public Label statusLabel;
    public static int y = 0;
    public static int x;


    // "initialize()" est appelé par JavaFX à l'affichage de la fenêtre
    @FXML
    public void initialize() {

        // Affichage un message "bloquant"
        showWarning("Ricochet Robots");



        //
        //              Construction du plateau en assemblant les planches
        Image planche1 = new Image("planche1.jpg", 300, 300, false, true);
        Image planche2 = new Image("planche2.jpg", 300, 300, false, true);
       Image planche3 = new Image("planche3.jpg", 300, 300, false, true);
        Image planche4 = new Image("planche4.jpg", 300, 300, false, true);
        // ... "1.png" doit être placé à la racine de "resources/" (sinon PB)
        for (int col = 0; col < 2; col++) {
            for (int lig = 0; lig < 2; lig++) {
                ImageView pl1 = new ImageView(planche1);
                pl1.setRotate(90);
               ImageView pl2 = new ImageView(planche2);
                pl2.setRotate(180);
                ImageView pl3 = new ImageView(planche3);
                ImageView pl4 = new ImageView(planche4);
                pl4.setRotate(-90);

                //  final int lambdaCol = col;
                // final int lambdaLig = lig;
                //tileGui.setOnMouseClicked
                       // (event -> {
                        //    String status = Game.context.processSelectTile
                        //            (lambdaCol, lambdaLig);
                          //  if ( "MOVE".equals(status)) {
                          //      updateSelectedRobotPosition();
                           // } else if (status != null) {
                          //      showWarning(status);
                          //  }
                       // });
                boardPane.add(pl1, 0, 0);
                boardPane.add(pl2, 1, 0);
                boardPane.add(pl3, 0, 1);
                boardPane.add(pl4, 1, 1);

                // Génération aléatoire d'un objectif

                List<ImageView> Cibles = new ArrayList<>();
                Image lunebleu = new Image("lunebleu.png");
                Image lunerouge = new Image("lunerouge.png");
                Image planetejaune = new Image("planetejaune.png");

                ImageView lunebleu1 = new ImageView(lunebleu);
                ImageView lunerouge1 = new ImageView(lunerouge);
                ImageView planetejaune1 = new ImageView(planetejaune);

                Cibles.add(lunerouge1);
                Cibles.add(lunebleu1);
                Cibles.add(planetejaune1);

                Random rand = new Random();
                int i = rand.nextInt(0,Cibles.size());
                ImageView cibleJeu = Cibles.get(i);


                boardPane.add(cibleJeu,7,7);
            }
        }

        // Ajout des pièces
       // addRobot(RED);
       // addRobot(GREEN);
      //  addRobot(BLUE);
       // addRobot(YELLOW);




     /*   boardPane.add(
                new ImageView( new Image(
                        Game.context.getTarget().getColor() + "_target.png",
                        TILE_SIZE, TILE_SIZE, false, true
                ) ),
                Game.context.getTarget().getCol(),
                Game.context.getTarget().getLig()
        );*/


        // "Binding JFX" - Synchronisation du "Label" avec l'état du jeu
        statusLabel.textProperty().bind(Game.context.statusToolTipProperty);

    }

    // Affiche une boite de dialogue construite avec "SceneBuilder"
    public void showPlayerView(ActionEvent actionEvent) throws IOException {
        if (Game.context.getStatus() == Game.Status.CHOOSE_PLAYER) {
            FXMLLoader fxmlLoader = new FXMLLoader
                    (MainApplication.class.getResource("player-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
    }

    private void addRobot(Token.Color color) {
        Token robot = Game.context.getRobots().get(color);
        ImageView robotGui = new ImageView(new Image(
                color.name() + "_robot.png",
                TILE_SIZE, TILE_SIZE, false, true
        ));
        robotGui.setOnMouseClicked
                (event -> Game.context.processSelectRobot(color));
        boardPane.add(robotGui, robot.getCol(), robot.getLig());
        // Association de l' "ImageView" avec le robot stocké dans le jeu
        robot.setGui(robotGui);
    }

    private void updateSelectedRobotPosition() {
        Token robot = Game.context.getSelectedRobot();
        GridPane.setConstraints(robot.getGui(), robot.getCol(), robot.getLig());
    }

    private void showWarning(String message) {
        Alert startMessage
                = new Alert(Alert.AlertType.INFORMATION, message);
        startMessage.setHeaderText(null);
        startMessage.setGraphic(null);
        startMessage.showAndWait();
    }

}

