package sio.code_secret;

import java.util.ArrayList;

public class Coffre {
    private int NbDepart1;
    private int NbDepart2;
    private int NbDepart3;
    private int NbDepart4;
    private int NbDepart5;
    private int NbDepart6;
    private ArrayList<Integer> code = new ArrayList<>();
    private ArrayList<Integer> proposition = new ArrayList<>();
    private static int NbTentative = 0;

    Perso perso;


    public Coffre() {
        this.NbDepart1 = 0;
        this.NbDepart2 = 0;
        this.NbDepart3 = 0;
        this.NbDepart4 = 0;
        this.NbDepart5 = 0;
        this.NbDepart6 = 0;
    }

    public int getNbDepart1() {
        return NbDepart1;
    }

    public int getNbDepart2() {
        return NbDepart2;
    }

    public int getNbDepart3() {
        return NbDepart3;
    }

    public int getNbDepart4() {
        return NbDepart4;
    }

    public int getNbDepart5() {
        return NbDepart5;
    }

    public int getNbDepart6() {
        return NbDepart6;
    }

    public void setNbDepart1(int valeur) {
        NbDepart1 = valeur;
    }

    public void setNbDepart2(int valeur) {
        NbDepart2 = valeur;
    }

    public void setNbDepart3(int valeur) {
        NbDepart3 = valeur;
    }

    public void setNbDepart4(int valeur) {
        NbDepart4 = valeur;
    }

    public void setNbDepart5(int valeur) {
        NbDepart5 = valeur;
    }

    public void setNbDepart6(int valeur) {
        NbDepart6 = valeur;
    }

    public int Increment(int valeur) {
        valeur++;


        if (perso.getCompetences().equals("Gros Bras")) {
            if (valeur > 6) {
                valeur = 0;
            }
            return valeur;
        }

        if (valeur > 9) {
            valeur = 0;
        }
        return valeur;
    }

    public int Decrement(int valeur) {
        valeur--;
        if (perso.getCompetences().equals("Gros Bras")) {
            if (valeur < 0) {
                valeur = 6;
            }
            return valeur;
        }
        if (valeur < 0) {
            valeur = 9;
        }
        return valeur;
    }

    public void alea_code(int min, int max) {
        code.clear();
        for (int i = 0; i < 6; i++) {
            int valeur = (int) (Math.random() * (max - min + 1)) + min;
            code.add(valeur);
        }
    }

    public void proposition_code() {
        proposition.clear();
        proposition.add(getNbDepart1());
        proposition.add(getNbDepart2());
        proposition.add(getNbDepart3());
        proposition.add(getNbDepart4());
        proposition.add(getNbDepart5());
        proposition.add(getNbDepart6());
    }

    public String compare() {
        int cpt_bien = 0;
        int cpt_mal_place = 0;
        int cpt_pas_present = 0;
        ArrayList<Integer> ResteCode = new ArrayList<>();
        ArrayList<Integer> ResteProposition = new ArrayList<>();

        for (int i = 0; i < code.size(); i++) {
            if (code.get(i).equals(proposition.get(i))) {
                cpt_bien++;
            } else {
                ResteCode.add(code.get(i));
                ResteProposition.add(proposition.get(i));
            }
        }
        for (int e = 0; e < ResteCode.size(); e++) {
            if (ResteProposition.contains(ResteCode.get(e))) {
                cpt_mal_place++;
                ResteProposition.remove(ResteCode.get(e));
            } else {
                cpt_pas_present++;
            }
        }

        if (cpt_bien == 6) {
            return "Bravo tu as gagné. Mon trésor t'appartient.";
        }
        if (cpt_bien == 5 && perso.getCompetences().equals("Brute Force")) {
            return "Bravo tu as gagné. Mon trésor t'appartient.";
        }

        if (cpt_bien == 1) {
            if (cpt_mal_place == 1) {
                return cpt_bien + " chiffre est bien placés et " + cpt_mal_place + " chiffre est mal placés \n et " + cpt_pas_present + " ne sont pas présent.";
            } else if (cpt_pas_present == 1) {
                return cpt_bien + " chiffre est bien placés et " + cpt_mal_place + " chiffres sont mal placés \n et " + cpt_pas_present + " n'est pas présent.";
            }
            return cpt_bien + " chiffre est bien placés et " + cpt_mal_place + " chiffres sont mal placés \n et " + cpt_pas_present + " ne sont pas présent.";

        } else if (cpt_mal_place == 1) {
            if (cpt_pas_present == 1) {
                return cpt_bien + " chiffres sont bien placés et " + cpt_mal_place + " chiffre est mal placés \n et " + cpt_pas_present + " n'est pas présent.";
            }
            return cpt_bien + " chiffres sont bien placés et " + cpt_mal_place + " chiffre est mal placés \n et " + cpt_pas_present + " ne sont pas présent.";

        } else if (cpt_pas_present == 1) {
            return cpt_bien + " chiffres sont bien placés et " + cpt_mal_place + " chiffres sont mal placés \n et " + cpt_pas_present + " n'est pas présent.";

        } else {
            return cpt_bien + " chiffres sont bien placés et " + cpt_mal_place + " chiffres sont mal placés \n et " + cpt_pas_present + " ne sont pas présent.";
        }

    }

    public String mal_de_mer() {
        int cpt_bien = 0;
        int cpt_mal_place = 0;
        int cpt_pas_present = 0;
        ArrayList<Integer> ResteCode = new ArrayList<>();
        ArrayList<Integer> ResteProposition = new ArrayList<>();

        for (int i = 0; i < code.size(); i++) {
            if (code.get(i).equals(proposition.get(i))) {
                cpt_bien++;
            } else {
                ResteCode.add(code.get(i));
                ResteProposition.add(proposition.get(i));
            }
        }
        for (int e = 0; e < ResteCode.size(); e++) {
            if (ResteProposition.contains(ResteCode.get(e))) {
                cpt_mal_place++;
                ResteProposition.remove(ResteCode.get(e));
            } else {
                cpt_pas_present++;
            }
        }
        return cpt_pas_present + " chiffres sont bien placés et " + cpt_bien + " chiffres sont mal placés \n et " + cpt_mal_place + " ne sont pas présent.";
    }

    public void changement_de_cap() {
        if (perso.getCompetences().equals("Brute Force")) {
            int valeur = (int) (Math.random() * (5 + 1));
            int nv_chiffre = (int) (Math.random() * (6 + 1));
            code.remove(valeur);
            code.add(valeur, nv_chiffre);
        } else {
            int valeur = (int) (Math.random() * (5 + 1));
            int nv_chiffre = (int) (Math.random() * (9 + 1));
            code.remove(valeur);
            code.add(valeur, nv_chiffre);
        }
    }

    public String Brouillard_marin() {
        int cpt_bien = 0;
        int cpt_mal = 0;
        for (int i = 0; i < code.size(); i++) {
            if (code.get(i).equals(proposition.get(i))) {
                cpt_bien++;
            } else {
                cpt_mal++;
            }
        }
        if (cpt_bien == 1) {
            return cpt_bien + " chiffre est  bien placés et " + cpt_mal + " chiffres sont mal placés \n ou pas présent";
        } else if (cpt_mal == 1) {
            return cpt_bien + " chiffres sont bien placés et " + cpt_mal + " chiffre est  mal placés \n ou pas présent";
        } else {
            return cpt_bien + " chiffres sont bien placés et " + cpt_mal + " chiffres sont mal placés \nou pas présent";
        }
    }

    public int somme() {
        int somme = 0;
        for (int i = 0; i < code.size(); i++) {
            somme = somme + code.get(i);
        }
        return somme;
    }

    public String compareSomme() {
        int somme1 = 0;
        int somme2 = 0;
        for (int i = 0; i < code.size(); i++) {
            somme1 = somme1 + code.get(i);
            somme2 = somme2 + proposition.get(i);
        }
        if (somme2 > somme1) {
            return "Supérieur";
        } else if (somme2 < somme1) {
            return "Inférieur";
        } else {
            return "Égal";
        }

    }


    public int NbTenta() {
        NbTentative++;
        return NbTentative;
    }

    public void resetNbTentative() {
        NbTentative = 0;
    }

    public void persoActuelle (Perso perso){
        this.perso = perso;
    }
}



