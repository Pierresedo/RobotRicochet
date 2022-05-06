package com.example.robotricochet;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Carre extends Application implements EventHandler<KeyEvent> {
    Rectangle r;
    Group root;
    public Carre() {
        r = new Rectangle();
        root = new Group();
        r.setX(100); r.setY(50);
        r.setWidth(100); r.setHeight(5);
        r.setFill(Color.GRAY);
        root.getChildren().add(r);
        if(root.getLayoutX() < r.getBoundsInParent().getMaxX()) {r.setX(50);}
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Carré qui bouge");
        Scene scene = new Scene(root,200,100);
        scene.setOnKeyPressed(this);
        primaryStage.setScene(scene);
        primaryStage.show(); }
    @Override
    public void handle(KeyEvent event) {
        System.out.println("Appuyer sur "+event.getCode());
        switch (event.getCode()) {
            case UP: r.setY(r.getY()-10); break;
            case DOWN: r.setY(r.getY()+10); break;
            case LEFT: r.setX(r.getX()-100); break;
            case RIGHT: r.setX(r.getX()+100); break;
            case Z: r.setY(r.getY()-100); break;
            case S: r.setY(r.getY()+100); break;
            case Q: r.setX(r.getX()-100); break;
            case D: r.setX(r.getX()+100); break;
            default: break;
        }
    }
    public static void main(String[] args) { launch(args);}
}