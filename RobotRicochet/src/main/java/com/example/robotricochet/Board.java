package com.example.robotricochet;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import com.example.robotricochet.obstacle;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static com.example.robotricochet.obstacle.*;


public class Board extends Application {

    //dimensions du plateau et de ces cellules

    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;
    public static final  int CELL_SIZE = 35;

    private Cell[][] board = new Cell[WIDTH][HEIGHT];
    private Group cellgroup = new Group();
    private Label welcome = new Label("Ricochet Robot");
    private Image bg;
    private Rectangle test = new Rectangle(WIDTH * Board.CELL_SIZE+15, (HEIGHT * Board.CELL_SIZE)+14);

    // Création de la fênetre

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(createContent());
        stage.setTitle("Robot Ricochet");
        stage.setScene(scene);
        stage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(1080, 720);

        bg = new Image("bg1.jpg");
        Image bord = new Image("bord.jpg");
        ImageView vbg = new ImageView(bg);
        root.getChildren().add(vbg);

        //le border du plateau

        test.setStroke(new ImagePattern(bord));
        test.setStrokeWidth(5);
        test.setLayoutX(10);
        test.setLayoutY(-1);

        //Ricochet Robot

        welcome.setStyle("-fx-font: 16 arial;-fx-text-fill: red; -fx-font-weight: bold;");
        welcome.setLayoutX(800);
        welcome.setLayoutY(29);

        // définition du groupe qui va contenir le plateau

        cellgroup.setLayoutX(10);
        cellgroup.setLayoutY(20);
        cellgroup.getChildren().add(test);
        root.getChildren().addAll(cellgroup,welcome);//ajout du plateau et du texte dans la fênetre

        //création du plateau

        for(int y=0; y < HEIGHT;y++) {
            for (int x = 0; x < WIDTH; x++) {
                Cell cell = new Cell(x,y);
                board[x][y] = cell;
                cellgroup.getChildren().add(cell);
            }
        }
       cellgroup.getChildren().addAll(ob1,ob2,ob3,ob4,ob5,ob6,ob7,ob8,ob11,ob12,ob13);//ajout des obstacles au plateau

        return root;
    }
}
