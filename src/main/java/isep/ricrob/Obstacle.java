package isep.ricrob;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {
    public static final int lv = 5;
    public static final int Lv = 40;
    public static final int lh = 40;
    public static final int Lh = 5;

    private Image cellule= new Image("bord.jpg");

    public Obstacle( int l, int L) {
        setHeight(L);
        setWidth(l);
        setFill(new ImagePattern(cellule));
    }

    public static Obstacle obV = new Obstacle(lv,Lv);// Obstacle vertical
    public static Obstacle obH = new Obstacle(lh,Lh); // Obstacle Horizontal


}
