package sio.code_secret;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ImageView fond;
    @FXML
    private Label lblNb1;
    @FXML
    private Label lblNb2;
    @FXML
    private Label lblNb3;
    @FXML
    private Label lblNb4;
    @FXML
    private Label lblNb5;
    @FXML
    private Label lblNb6;
    @FXML
    private Label lblTest;
    @FXML
    private Label lblTentative;
    @FXML
    private Label lblMalus;
    @FXML
    private Label lblInfoMalus;
    @FXML
    private Label lblInfotentative;
    @FXML
    private Label lblInfoComp1;
    @FXML
    private Label lblInfoComp2;
    @FXML
    private Label lblChance;
    @FXML
    private Label lblSomme;
    @FXML
    private Label lblInfoSomme;
    @FXML
    private Label lblDescriptionMalus;
    @FXML
    private Label lblFondVictoire;
    @FXML
    private Button ClickUp1;
    @FXML
    private Button ClickUp2;
    @FXML
    private Button ClickUp3;
    @FXML
    private Button ClickUp4;
    @FXML
    private Button ClickUp5;
    @FXML
    private Button ClickUp6;
    @FXML
    private Button ClickDown1;
    @FXML
    private Button ClickDown2;
    @FXML
    private Button ClickDown3;
    @FXML
    private Button ClickDown4;
    @FXML
    private Button ClickDown5;
    @FXML
    private Button ClickDown6;
    @FXML
    private Button ClickValider;
    @FXML
    private Button ClickIntello;
    @FXML
    private Button ClickBrute;
    @FXML
    private Button ClickChanceux;
    @FXML
    private Button ClickOK;
    @FXML
    private Button ClickDeduction;
    @FXML
    private Button ClickIntuition;
    @FXML
    private Button ClickBruteForce;
    @FXML
    private Button ClickGrosBras;
    @FXML
    private Button ClickChance;
    @FXML
    private Button ClickPasser;
    @FXML
    private Button ClickRejouer;
    @FXML
    private Button ClickQuitter;


    Coffre coffre;
    Malus malus;
    Perso perso;

    int cpt=0;
    int tourMalus=0;
    int dialogue=0;
    String choix="";
    String phrase;
    boolean protection=true;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dialogue=0;
        presentation();
        cacher_boutons(false);
        fond.setImage(new Image(getClass().getResourceAsStream("/images/coffre.png")));
        coffre = new Coffre();
        malus = new Malus();

        this.lblNb1.setText(String.valueOf(this.coffre.getNbDepart1()));
        this.lblNb2.setText(String.valueOf(this.coffre.getNbDepart2()));
        this.lblNb3.setText(String.valueOf(this.coffre.getNbDepart3()));
        this.lblNb4.setText(String.valueOf(this.coffre.getNbDepart4()));
        this.lblNb5.setText(String.valueOf(this.coffre.getNbDepart5()));
        this.lblNb6.setText(String.valueOf(this.coffre.getNbDepart6()));


    }
    public void ClickUp1(){
        int valeur = coffre.Increment(coffre.getNbDepart1());
        coffre.setNbDepart1(valeur);
        this.lblNb1.setText(String.valueOf(valeur));
    }
    public void ClickUp2(){
        int valeur = coffre.Increment(coffre.getNbDepart2());
        coffre.setNbDepart2(valeur);
        this.lblNb2.setText(String.valueOf(valeur));
    }
    public void ClickUp3(){
        int valeur = coffre.Increment(coffre.getNbDepart3());
        coffre.setNbDepart3(valeur);
        this.lblNb3.setText(String.valueOf(valeur));
    }
    public void ClickUp4(){
        int valeur = coffre.Increment(coffre.getNbDepart4());
        coffre.setNbDepart4(valeur);
        this.lblNb4.setText(String.valueOf(valeur));
    }
    public void ClickUp5(){
        int valeur = coffre.Increment(coffre.getNbDepart5());
        coffre.setNbDepart5(valeur);
        this.lblNb5.setText(String.valueOf(valeur));
    }
    public void ClickUp6(){
        int valeur = coffre.Increment(coffre.getNbDepart6());
        coffre.setNbDepart6(valeur);
        this.lblNb6.setText(String.valueOf(valeur));
    }

    public void ClickDown1(){
        int valeur = coffre.Decrement(coffre.getNbDepart1());
        coffre.setNbDepart1(valeur);
        this.lblNb1.setText(String.valueOf(valeur));
    }
    public void ClickDown2(){
        int valeur = coffre.Decrement(coffre.getNbDepart2());
        coffre.setNbDepart2(valeur);
        this.lblNb2.setText(String.valueOf(valeur));
    }
    public void ClickDown3(){
        int valeur = coffre.Decrement(coffre.getNbDepart3());
        coffre.setNbDepart3(valeur);
        this.lblNb3.setText(String.valueOf(valeur));
    }
    public void ClickDown4(){
        int valeur = coffre.Decrement(coffre.getNbDepart4());
        coffre.setNbDepart4(valeur);
        this.lblNb4.setText(String.valueOf(valeur));
    }
    public void ClickDown5(){
        int valeur = coffre.Decrement(coffre.getNbDepart5());
        coffre.setNbDepart5(valeur);
        this.lblNb5.setText(String.valueOf(valeur));
    }
    public void ClickDown6(){
        int valeur = coffre.Decrement(coffre.getNbDepart6());
        coffre.setNbDepart6(valeur);
        this.lblNb6.setText(String.valueOf(valeur));
    }

    public void ClickValider(){
        coffre.proposition_code();

        if(perso.getCompetences().equals("Déduction")) {
            this.lblSomme.setText(coffre.compareSomme());
        }
        cpt++;
        if(tourMalus==0){
            this.lblMalus.setText("");
            choix = "";
        }
        appliquerMalus();
        if(cpt==10){
            if("Chanceux".equals(perso.getType())&& protection){
                protection=false;
                cpt=0;
            }else {
                choix = malus.aleaMalus();
                cpt = 0;
                this.lblMalus.setText(choix);
                tourMalus = 3;
                appliquerMalus();
            }
        }
        this.lblTentative.setText(String.valueOf(coffre.NbTenta()));
    }


    public void appliquerMalus(){
        if(tourMalus>0 && "brouillard marin".equals(choix)){
            this.lblDescriptionMalus.setText("Moins d'information \n te sont données");
            this.lblDescriptionMalus.setVisible(true);
            this.lblTest.setText(coffre.Brouillard_marin());
            tourMalus--;
        } else if(tourMalus>0 && "changement de cap".equals(choix)){
            this.lblDescriptionMalus.setVisible(true);
            this.lblDescriptionMalus.setText("Change un chiffre\n aléatoire du code");
            coffre.changement_de_cap();
            tourMalus = tourMalus - 3;
        } else if(tourMalus>0 && "mal de mer".equals(choix)){
            this.lblDescriptionMalus.setVisible(true);
            this.lblDescriptionMalus.setText("les informations \n sont mélangés");
            this.lblTest.setText(coffre.mal_de_mer());
            tourMalus--;
        } else {
            this.lblTest.setText(coffre.compare());
            this.lblDescriptionMalus.setVisible(false);
        }
        verifVictoire();
    }


    public void ClickIntello(){
        phrase=" Intellectuel? Intéressant ton type possède 2 compétences. \nLaquelle choisiras-tu? ";
        this.lblInfoComp1.setText("En début de partie \n la somme de tout les \n chiffres t'es donnés.");
        this.lblInfoComp2.setText("Apres chaque tentative\n tu sais si la somme de\n ta proposition est superieure\n a celle du code");
        ClickIntello.setVisible(false);
        ClickBrute.setVisible(false);
        ClickChanceux.setVisible(false);
        dialogue=13;
        presentation();
    }

    public void ClickBrute(){
        phrase=" Brute? Intéressant ton type possède 2 compétences. \nLaquelle choisiras-tu? ";
        this.lblInfoComp1.setText("Il se suffit de trouver\n 5 chiffres pour \n ouvrir le coffre");
        this.lblInfoComp2.setText("Tout les chiffres qui \n composent le code sont\n entre 0 et 6");
        ClickIntello.setVisible(false);
        ClickBrute.setVisible(false);
        ClickChanceux.setVisible(false);
        dialogue=14;
        presentation();
    }

    public void ClickChanceux(){
        phrase=" Chanceux? Intéressant ton type ne possède \n qu'une seule compétences.";
        this.lblChance.setText("Le premier Malus est ignoré.");
        ClickIntello.setVisible(false);
        ClickBrute.setVisible(false);
        ClickChanceux.setVisible(false);
        dialogue=15;
        presentation();
    }


    public void ClickIntuition(){
        perso = new Perso("Intellectuel","Intuition");
        coffre.persoActuelle(perso);
        this.lblTest.setText("Très bien que la partie commence");
        ClickIntuition.setVisible(false);
        ClickDeduction.setVisible(false);
        this.lblInfoComp1.setVisible(false);
        this.lblInfoComp2.setVisible(false);
        this.lblSomme.setVisible(true);
        this.lblInfoSomme.setVisible(true);
        coffre.alea_code(0,9);
        this.lblSomme.setText(String.valueOf(coffre.somme()));
        cacher_boutons(true);
    }
    public void ClickDeduction(){
        perso = new Perso("Intellectuel","Déduction");
        coffre.persoActuelle(perso);
        this.lblTest.setText("Très bien que la partie commence");
        ClickIntuition.setVisible(false);
        ClickDeduction.setVisible(false);
        this.lblInfoComp1.setVisible(false);
        this.lblInfoComp2.setVisible(false);
        this.lblSomme.setVisible(true);
        this.lblInfoSomme.setVisible(true);
        cacher_boutons(true);
        coffre.alea_code(0,9);
    }

    public void ClickBruteForce(){
        perso = new Perso("Brute","Brute Force");
        coffre.persoActuelle(perso);
        coffre.persoActuelle(perso);
        this.lblTest.setText("Très bien que la partie commence");
        ClickBruteForce.setVisible(false);
        ClickGrosBras.setVisible(false);
        this.lblInfoComp1.setVisible(false);
        this.lblInfoComp2.setVisible(false);
        coffre.alea_code(0,9);
        cacher_boutons(true);
    }

    public void ClickGrosBras(){
        perso = new Perso("Brute","Gros Bras");
        coffre.persoActuelle(perso);
        this.lblTest.setText("Très bien que la partie commence");
        ClickBruteForce.setVisible(false);
        ClickGrosBras.setVisible(false);
        this.lblInfoComp1.setVisible(false);
        this.lblInfoComp2.setVisible(false);
        cacher_boutons(true);
        coffre.alea_code(0,6);
    }

    public void ClickChance(){
        perso = new Perso("Chanceux");
        coffre.persoActuelle(perso);
        this.lblTest.setText("Très bien que la partie commence");
        ClickChance.setVisible(false);
        this.lblChance.setVisible(false);
        cacher_boutons(true);
        coffre.alea_code(0,9);
    }


    public void ClickPasser(){
        ClickOK.setVisible(false);
        ClickPasser.setVisible(false);
        dialogue=12;
        phrase="Maintenant que je t'ai tout expliqué dit moi \n  quelle type de pirate tu est";
        presentation();
    }


    public void cacher_boutons(boolean cacher){
        ClickUp1.setVisible(cacher);
        ClickUp2.setVisible(cacher);
        ClickUp3.setVisible(cacher);
        ClickUp4.setVisible(cacher);
        ClickUp5.setVisible(cacher);
        ClickUp6.setVisible(cacher);
        ClickDown1.setVisible(cacher);
        ClickDown2.setVisible(cacher);
        ClickDown3.setVisible(cacher);
        ClickDown4.setVisible(cacher);
        ClickDown5.setVisible(cacher);
        ClickDown6.setVisible(cacher);
        ClickValider.setVisible(cacher);
        this.lblTest.setVisible(cacher);
        this.lblInfotentative.setVisible(cacher);
        this.lblInfoMalus.setVisible(cacher);
    }



    public void ClickOK(){
        if (dialogue==1){
            phrase="Je suppose que tu est ici pour mon trésor comme tout \n les autres qui sont venus avant toi.";
        }else if(dialogue==3){
            phrase="Malheuresement pour toi ce coffre est protege par un \n code à 6 chiffres que tu devra trouver.";
        } else if (dialogue==5) {
            phrase="Ce coffre est aussi magique, ce qui veut dire qu'il te donnera \n des malus au fil du temps";
        }else if (dialogue==7) {
            phrase="En haut à droite de ta fenetre tu trouvera le nombre de \n tentative effectuer. Le coffre te donne des malus toutes \n les 10 tentatives donc fait attention";
        }else if (dialogue==9) {
            phrase="En haut à gauche tu trouvera le malus qui est actuellement \n en train de faire effet";
        }else if (dialogue==11) {
            phrase="Maintenant que je t'ai tout expliqué dit moi \n  quelle type de pirate tu est";
        }
        ClickOK.setVisible(false);
        dialogue++;
        presentation();
    }


    public void presentation() {
        PauseTransition transition1 = new PauseTransition(Duration.seconds(0.2));
        PauseTransition transition2 = new PauseTransition(Duration.seconds(0.2));
        PauseTransition transition3 = new PauseTransition(Duration.seconds(1));
        PauseTransition transition4 = new PauseTransition(Duration.seconds(1));
        PauseTransition transition5 = new PauseTransition(Duration.seconds(1));

        if (dialogue == 0) {
            phrase = "Oh un pirate. Cela fait bien longtemps que \n je n'en avais pas vu ici.";
            transition1 = new PauseTransition(Duration.seconds(0.4));
            transition2 = new PauseTransition(Duration.seconds(0.5));
            transition3 = new PauseTransition(Duration.seconds(0.5));

            transition1.setOnFinished(event -> this.lblTest.setVisible(true));
            transition2.setOnFinished(event -> this.lblTest.setText(phrase));
            transition3.setOnFinished(event -> ClickOK.setVisible(true));

        } else if (dialogue==2){
            transition2.setOnFinished(event ->this.lblTest.setText(phrase));
            transition3.setOnFinished(event ->ClickOK.setVisible(true));

        } else if (dialogue==4) {
            transition2.setOnFinished(event ->this.lblTest.setText(phrase));
            transition3.setOnFinished(event ->ClickOK.setVisible(true));

        }else if (dialogue==6) {
            transition2.setOnFinished(event ->this.lblTest.setText(phrase));
            transition3.setOnFinished(event ->ClickOK.setVisible(true));

        }else if (dialogue==8) {
            transition2.setOnFinished(event ->this.lblTest.setText(phrase));
            transition1.setOnFinished(event -> this.lblInfotentative.setVisible(true));
            transition3.setOnFinished(event ->ClickOK.setVisible(true));

        }else if (dialogue==10) {
            transition2.setOnFinished(event ->this.lblTest.setText(phrase));
            transition1.setOnFinished(event -> this.lblInfoMalus.setVisible(true));
            transition3.setOnFinished(event ->ClickOK.setVisible(true));

        }else if (dialogue==12) {
            transition1 = new PauseTransition(Duration.seconds(1));
            transition2.setOnFinished(event ->this.lblTest.setText(phrase));
            transition1.setOnFinished(event -> ClickIntello.setVisible(true));
            transition3.setOnFinished(event ->ClickBrute.setVisible(true));
            transition4.setOnFinished(event -> ClickChanceux.setVisible(true));
            transition5.setOnFinished(event -> ClickPasser.setVisible(false));

        } else if (dialogue==13) {
            transition1 = new PauseTransition(Duration.seconds(1));
            transition2.setOnFinished(event ->this.lblTest.setText(phrase));
            transition1.setOnFinished(event -> ClickIntuition.setVisible(true));
            transition3.setOnFinished(event -> ClickDeduction.setVisible(true));
            transition4.setOnFinished(event -> this.lblInfoComp1.setVisible(true));
            transition5.setOnFinished(event -> this.lblInfoComp2.setVisible(true));
        } else if (dialogue==14) {
            transition1 = new PauseTransition(Duration.seconds(1));
            transition2.setOnFinished(event -> this.lblTest.setText(phrase));
            transition1.setOnFinished(event -> ClickBruteForce.setVisible(true));
            transition3.setOnFinished(event -> ClickGrosBras.setVisible(true));
            transition4.setOnFinished(event -> this.lblInfoComp1.setVisible(true));
            transition5.setOnFinished(event -> this.lblInfoComp2.setVisible(true));
        } else if (dialogue==15) {
            transition2.setOnFinished(event -> this.lblTest.setText(phrase));
            transition3.setOnFinished(event -> ClickChance.setVisible(true));
            transition4.setOnFinished(event -> this.lblChance.setVisible(true));
        }
        transition1.play();
        transition2.play();
        transition3.play();
        transition4.play();
        transition5.play();
        dialogue++;
    }

    public void verifVictoire(){
        PauseTransition transition = new PauseTransition(Duration.seconds(2));
        PauseTransition transition2 = new PauseTransition(Duration.seconds(3));
        PauseTransition coffre = new PauseTransition(Duration.seconds(3));
        PauseTransition coffre2 = new PauseTransition(Duration.seconds(3));
        PauseTransition rejouer = new PauseTransition(Duration.seconds(4));
        PauseTransition quitter = new PauseTransition(Duration.seconds(4));

        if(this.lblTest.getText().equals("Bravo tu as gagné. Mon trésor t'appartient.")){
            cacher_boutons(false);
            this.lblMalus.setVisible(false);
            this.lblTentative.setVisible(false);
            this.lblInfoSomme.setVisible(false);
            this.lblSomme.setVisible(false);
            this.lblDescriptionMalus.setVisible(false);
            this.lblTest.setVisible(true);

            transition.setOnFinished(event -> this.lblFondVictoire.setVisible(true));
            transition2.setOnFinished(event -> this.lblFondVictoire.setVisible(false));
            coffre.setOnFinished(event -> fond.setImage(new Image(getClass().getResourceAsStream("/images/coffre_ouvert.png"))));
            coffre2.setOnFinished(event -> this.lblTest.setVisible(false));
            rejouer.setOnFinished(event -> ClickRejouer.setVisible(true));
            quitter.setOnFinished(event -> ClickQuitter.setVisible(true));


            this.lblNb1.setText("");
            this.lblNb2.setText("");
            this.lblNb3.setText("");
            this.lblNb4.setText("");
            this.lblNb5.setText("");
            this.lblNb6.setText("");

            transition.play();
            transition2.play();
            coffre.play();
            coffre2.play();
            rejouer.play();
            quitter.play();

        }
    }

    public void ClickRejouer(){
        cpt=0;
        tourMalus=0;
        dialogue=0;
        choix="";
        protection=true;
        this.lblTentative.setText("");
        ClickRejouer.setVisible(false);
        ClickQuitter.setVisible(false);
        ClickPasser.setVisible(true);
        this.lblTentative.setVisible(true);
        presentation();
        cacher_boutons(false);
        fond.setImage(new Image(getClass().getResourceAsStream("/images/coffre.png")));
        coffre = new Coffre();
        malus = new Malus();
        this.lblTest.setVisible(false);
        coffre.resetNbTentative();

        this.lblNb1.setText(String.valueOf(this.coffre.getNbDepart1()));
        this.lblNb2.setText(String.valueOf(this.coffre.getNbDepart2()));
        this.lblNb3.setText(String.valueOf(this.coffre.getNbDepart3()));
        this.lblNb4.setText(String.valueOf(this.coffre.getNbDepart4()));
        this.lblNb5.setText(String.valueOf(this.coffre.getNbDepart5()));
        this.lblNb6.setText(String.valueOf(this.coffre.getNbDepart6()));

    }

    public void ClickQuitter(){
        System.exit(0);
    }
}

