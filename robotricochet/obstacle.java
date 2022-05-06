package com.example.robotricochet;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class obstacle extends Rectangle {
    public static final int lv = 5;
    public static final int Lv = 35;
    public static final int lh = 35;
    public static final int Lh = 5;
    private Image cellule= new Image("bord.jpg");

    public static obstacle ob1 = new obstacle(152,4,lv,Lv);
    public static obstacle ob2 = new obstacle(152+Board.CELL_SIZE*6,4,lv,Lv);
    public static obstacle ob3 = new obstacle(152+Board.CELL_SIZE,4+15*Board.CELL_SIZE,lv,Lv);
    public static obstacle ob4 = new obstacle(47+Board.CELL_SIZE*10,4+15*Board.CELL_SIZE,lv,Lv);
    public static obstacle ob5 = new obstacle(14,38+Board.CELL_SIZE*3,lh,Lh);
    public static obstacle ob6 = new obstacle(14,38+Board.CELL_SIZE*10,lh,Lh);
    public static obstacle ob7 = new obstacle(15+Board.CELL_SIZE*15,38+Board.CELL_SIZE,lh,Lh);
    public static obstacle ob8 = new obstacle(15+Board.CELL_SIZE*15,38+Board.CELL_SIZE*11,lh,Lh);
    public static obstacle ob11 = new obstacle(15+Board.CELL_SIZE*13,38+Board.CELL_SIZE,lh+2,Lh);
    public static obstacle ob12 = new obstacle(47+Board.CELL_SIZE*13,4+Board.CELL_SIZE,lv,Lv);
    public static obstacle ob13 = new obstacle(68+Board.CELL_SIZE*13,38+Board.CELL_SIZE,lv,Lv);

    public obstacle(int x, int y, int l, int L) {
        setHeight(L);
        setWidth(l);
        setX(x);
        setY(y);
        setFill(new ImagePattern(cellule));
    }


}
