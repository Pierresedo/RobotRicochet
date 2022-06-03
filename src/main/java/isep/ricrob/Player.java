package isep.ricrob;

import java.util.ArrayList;
import java.util.List;

public class Player {
    
    private int proposition;
    public List<Token> pions = new ArrayList<>();


    public Player(int proposition) {
        this.proposition = proposition;
    }

    public void addPion(int a, Token token) {
        if(a==this.proposition) {pions.add(token);}
        else{
            System.out.println("Vous avez perdu");
        }
    }

}
