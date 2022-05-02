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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class Board extends Application {
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;
    public static final  int CELL_SIZE = 35;
    private Cell[][] board = new Cell[WIDTH][HEIGHT];
    private Group cellgroup = new Group();
    private Label welcome = new Label("Ricochet Robot");
    private Rectangle test = new Rectangle(WIDTH * Board.CELL_SIZE+15, (HEIGHT * Board.CELL_SIZE)+14);



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
        Image bg = new Image("C:\\Users\\PIERRE SEDO\\Downloads\\Project-Java-master\\RobotRicochet\\src\\main\\java\\com\\example\\robotricochet\\ricochet-robots.jpg");
        Image bord = new Image("C:\\Users\\PIERRE SEDO\\Downloads\\Project-Java-master\\RobotRicochet\\src\\main\\java\\com\\example\\robotricochet\\bord.jpg");

        cellgroup.setLayoutX(10);
        cellgroup.setLayoutY(20);
        test.setStroke(new ImagePattern(bord));
        test.setStrokeWidth(5);
        test.setLayoutX(10);
        test.setLayoutY(-1);

        welcome.setStyle("-fx-font: 16 arial;-fx-text-fill: red; -fx-font-weight: bold;");
        welcome.setLayoutX(800);
        welcome.setLayoutY(29);
        root.getChildren().addAll(cellgroup,welcome);
        cellgroup.getChildren().add(test);

        for(int y=0; y < HEIGHT;y++) {
            for (int x = 0; x < WIDTH; x++) {
                Cell cell = new Cell(x,y);
                board[x][y] = cell;
                cellgroup.getChildren().add(cell);
            }
        }

        return root;
    }
}
