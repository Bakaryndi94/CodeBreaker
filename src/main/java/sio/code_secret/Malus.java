package sio.code_secret;

import java.util.ArrayList;

public class Malus {
    ArrayList<String> malus = new ArrayList<>();

    public Malus(){
        malus.clear();
        malus.add("mal de mer");
        malus.add("changement de cap");
        malus.add("brouillard marin");
    }

    public String aleaMalus(){
        String choix = "";
        int valeur = (int) (Math.random() * (2 + 1));
        choix = malus.get(valeur);
        return choix;
    }


}
