package Model;

import java.util.ArrayList;

public class Adherant {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private ArrayList<Livre> listLivres;

    public Adherant(String identifiant, String nom, String prenom, String email, ArrayList<Livre> listLivres) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.listLivres = listLivres;
    }
}
