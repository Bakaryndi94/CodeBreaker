package sio.code_secret;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Perso {
    private String type;
    private String competences;


    public Perso(String type,String competences){
        this.type=type;
        this.competences=competences;
    }

    public Perso(String type){
        this.type=type;
        this.competences="chance du débutant";
    }

    public String getCompetences() {
        return competences;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setCompetences(String competences) {
        this.competences = competences;
    }

}

