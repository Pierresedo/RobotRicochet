package com.example.robotricochet;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;



public class Cell extends Rectangle {
     Image cellule= new Image("C:\\Users\\PIERRE SEDO\\Downloads\\Project-Java-master\\RobotRicochet\\src\\main\\java\\com\\example\\robotricochet\\img\\cell.jpg");

    public Cell(int x, int y) {
        setHeight(Board.CELL_SIZE);
        setWidth(Board.CELL_SIZE);
        relocate(x * Board.CELL_SIZE+15, y * Board.CELL_SIZE+5);
        //setFill(Color.valueOf("#C5C5C5"));
        setFill(new ImagePattern(cellule));
        setStroke(Color.WHITE);

    }


}
