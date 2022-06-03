package isep.ricrob;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test

    // On teste si le pion est empoché par le joueur lorsqu'il réalise le nombre de coups annoncé
    public void propositionTest() {
        Player pierre = new Player(17);//Le joueur annonce 17 coups
        Token red = new Token(Token.Color.RED);
        pierre.addPion(17,red);// On suppose que le joueur réalise 17 coup et
        // on vérifie si Le pion va dans sa liste

        assertTrue(pierre.pions.size()==1);

    }

}


